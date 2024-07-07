package com.user.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("RATING-SERVICE")
public interface RatingService {

}
