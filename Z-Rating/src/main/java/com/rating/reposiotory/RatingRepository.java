package com.rating.reposiotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{

	//custome finder methods
	List<Rating> findByUserId(int userId);
	List<Rating> findByHotelId(int hotelId);
}
