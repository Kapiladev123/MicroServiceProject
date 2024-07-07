package com.gateway.model;


import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponse {

	private String userID;
	
	private String accessToken;
	
	private String refresToken;
	
	private  long expireAt;
	
	private Collection<String> authorities;
	
	
	
}
