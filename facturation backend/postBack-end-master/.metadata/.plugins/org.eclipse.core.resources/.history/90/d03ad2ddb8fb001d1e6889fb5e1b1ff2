package com.app.security.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.app.models.User;
import com.app.repository.UserRepository;
import com.app.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
	@Autowired
    private UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${cni.app.jwtSecret}")
	private String jwtSecret;

	@Value("${cni.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.claim("userId", userPrincipal.getId())
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public Long getUserIdFromJwtToken(String token) {
	    Claims claims = Jwts.parser()
	            .setSigningKey(jwtSecret)
	            .parseClaimsJws(token)
	            .getBody();

	    return Long.parseLong(claims.get("userId").toString());
	}
	/*public User getUserFromJwtToken(String token) {
	    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	    Long userId = Long.parseLong(claims.get("userId").toString());
	    return userRepository.findById(userId)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + userId));
	}*/	

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

	/*public Long getUserIdFromJwtToken(HttpServletRequest request, JwtUtils jwtUtils) {
	    String token = request.getHeader("Authorization").substring(7);
	    String username = jwtUtils.getUserNameFromJwtToken(token);
	    User user = userRepository.findByUsername(username)
	    		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found with username: " + username));
	    return user.getId();
	}*/

	/*public Long getUserIdFromJwtToken(String token) {
	    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	    return Long.parseLong(claims.get("userId").toString());
	}*/



	
}