package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel saveHotel = hotelService.saveHotel(hotel);
	return new ResponseEntity<Hotel>(saveHotel,HttpStatus.CREATED);
	}
	

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> allHotel = hotelService.getAllHotel();
		return new ResponseEntity<List<Hotel>>(allHotel, HttpStatus.OK);
	}

	@GetMapping("{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable int hotelId){
		Hotel hotel = hotelService.getHotel(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}

}
