package com.user.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.model.Hotel;



/**
 * Feign client interface for communicating with the "HOTEL-SERVICE" service.
 * <p>
 * This interface defines methods for accessing hotel-related endpoints in the "HOTEL-SERVICE".
 */
@FeignClient("HOTEL-SERVICE")
public interface HotelService {

    /**
     * Retrieves a single hotel by its ID from the "HOTEL-SERVICE".
     *
     * @param hotelId The ID of the hotel to retrieve.
     * @return The hotel object with the specified ID.
     */
    @GetMapping("api/hotel/{hotelId}")
    public Hotel getSingleHotel(@PathVariable int hotelId);
}

