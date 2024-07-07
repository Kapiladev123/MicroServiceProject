package com.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
/**
 * Controller class for managing user-related HTTP requests.
 * <p>
 * This class is responsible for handling requests related to creating, retrieving, and listing users.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	/**
     * Handles HTTP POST requests to create a new user.
     *
     * @param user The user object to be created.
     * @return ResponseEntity with the created user and HTTP status code.
     */
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
	}
	//int retryCount = 1;
	/**
	 * Handles HTTP GET requests to retrieve a single user by ID.
	 * <p>
	 * This method makes use of the Circuit Breaker pattern to handle failures gracefully.
	 * If the circuit is open, it invokes the fallback method {@code ratingHotelFallback}.
	 * The number of retries is logged for monitoring purposes.
	 *
	 * @param userId The ID of the user to retrieve.
	 * @return ResponseEntity with the retrieved user and HTTP status code.
	 */
	//get single user 
	@GetMapping("{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
//	@RateLimiter(name = "userRateLimiter",fallbackMethod ="ratingHotelFallback" )
	public ResponseEntity<User> getSingleuser(@PathVariable int userId){
		//logger.info("{}",retryCount);
		//retryCount++;
		User user = userService.getUser(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	 /**
     * Handles HTTP GET requests to retrieve all users.
     *
     * @return ResponseEntity with the list of all users and HTTP status code.
     */
	//get all user
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}
	
	/**
     * Fallback method for rate-limited requests to handle failures.
     * Fallback method for circuit-breakered requests to handle failures.
     * @param userId The ID of the user for which the request failed.
     * @param ex     The exception that caused the failure.
     * @return ResponseEntity with a fallback user object and HTTP status code.
     */
	//create  fall back method for circuitbreaker
	public ResponseEntity<User> ratingHotelFallback(int userId, Exception ex){
		ex.printStackTrace();
		User user = User.builder()
		.userEmail("kapil@gmail.com")
		.userName("kapil")
		.about("some service is down")
		.userId(12)
		.build();
		return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
	}
}
