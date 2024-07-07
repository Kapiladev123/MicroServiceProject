package com.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

	private int ratingId;
	private int userId;
	private int hotelId;
	private double rating;
	private String feeback;
	
	private Hotel hotel;
	
}
