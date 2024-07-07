package com.hotel.service;

import java.util.List;

import com.hotel.model.Hotel;

public interface HotelService {

	Hotel saveHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotel(int hotelId);
}
