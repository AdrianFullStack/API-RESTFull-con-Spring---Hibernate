package com.example.demo.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.util.Collections.emptyList;

public class JwtUtil {
	
	static void addAutentication(HttpServletResponse response, String email) {
		String token = Jwts.builder().setSubject(email)
				.signWith(SignatureAlgorithm.HS512, "@dri@n")
				.compact();
		
		response.addHeader("Authorization", "Bearer " + token);				
	}
	
	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token != null) {
			String user = Jwts.parser()
							.setSigningKey("@dri@n")
							.parseClaimsJws(token.replace("Bearer", ""))
							.getBody()
							.getSubject();
			return user != null ? 
					new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		
		return null;
	}

}
