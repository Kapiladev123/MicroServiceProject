package com.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.model.Rating;
import com.rating.reposiotory.RatingRepository;

@Service
public class RatingServiceImple implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	@Override
	public Rating saveRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRating(int ratingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> getAllRatingByUserId(int userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}

}
