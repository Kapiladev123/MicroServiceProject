 package com.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;
import com.user.exception.ResourceNotFoundException;
import com.user.feign.HotelService;
import com.user.model.Hotel;
import com.user.model.Rating;
import com.user.model.User;
import com.user.repository.UserRepository;
/**
 * Implementation of the {@link UserService} interface.
 * <p>
 * This class provides methods for performing CRUD (Create, Read, Update, Delete) operations on user entities.
 * It interacts with the underlying data access layer (e.g., {@link UserRepository}) to perform database operations.
 * Additionally, it makes use of {@link RestTemplate} to communicate with external services,
 * such as fetching ratings and hotels for users.
 */
@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImple.class);

	 /**
     * Saves a user entity to the database.
     *
     * @param user The user entity to be saved.
     * @return The saved user entity.
     */
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	 /**
     * Retrieves all user entities from the database.
     *
     * @return A list containing all user entities.
     */
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	/**
     * Retrieves a user entity from the database by its ID.
     * Additionally, fetches ratings and associated hotels for the user from external services.
     *
     * @param userId The ID of the user entity to retrieve.
     * @return The user entity with the specified ID, including its ratings with associated hotels.
     * @throws ResourceNotFoundException if the user with the given ID is not found.
     */
	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		//get the user from database with the help of repository
		User  user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("UserId Not Found : "+ userId));
		//fetch the rating of the user from RATING_SERVICE
		//localhost:8383/api/rating/user/2
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/api/rating/user/"+user.getUserId(), Rating[].class);
		logger.info("{}",ratingsOfUser);
		
		List<Rating> ratingses = Arrays.stream(ratingsOfUser).toList();
		
		
		List<Rating> ratingList = ratingses.stream().map(rating->{
			//api call to hotel service to get the hotel
			//localhost:8080/hotels/1
		//	ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotel/"+rating.getHotelId(), Hotel.class);
		//	Hotel hotel = forEntity.getBody();
			
			 Hotel hotel = hotelService.getSingleHotel(rating.getHotelId());
			//logger.info("response status code {}",forEntity.getStatusCode());
			
			//set the hotel to rating
			rating.setHotel(hotel);
			//return the rating
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		return user;
	}

}
