package com.rating.service;

import java.util.List;

import com.rating.model.Rating;

public interface RatingService {

	//create
	Rating saveRating(Rating rating);
	
	//getAllRating
	List<Rating> getAllRating();
	
	//getRating
	Rating getRating(int ratingId);
	
	//getAllRatingByUser
	List<Rating> getAllRatingByUserId(int userId);
	
	//getAllRatingByHotelId
	List<Rating> getAllRatingByHotelId(int hotelId);
	
}
