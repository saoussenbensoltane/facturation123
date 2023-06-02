package com.app.security.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.app.models.User;
import com.app.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void deleteUserByUsername(String username) {
        Optional<User> userOptional = userRepo.findByUsername(username);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());}}
    
    public List<User> searchUsers(String username, String email, String role) {
        List<User> users = new ArrayList<>();
        if (username != null) {
            Optional<User> user = userRepository.findByUsername(username);
            user.ifPresent(users::add);
        }
        if (email != null) {
            Optional<User> user = userRepository.findByEmail(email);
            user.ifPresent(users::add);
        }
        if (role != null) {
            List<User> usersWithRole = userRepository.findByRolesContainingIgnoreCase(role);
            users.addAll(usersWithRole);
        }

        return users;
    }
    
    public void deleteUserById(Long userId) {
		// entityManager.getTransaction().begin();
		Optional<User> user = userRepo.findById(userId);
		if(!user.isEmpty())
			userRepo.delete(user.get());
		//entityManager.remove(user);
	//	entityManager.getTransaction().commit();
	}
    public void updateUser(String username, String email, String password, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            userRepository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
    
    public void blockUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBlocked(true);
            userRepository.save(user);
        }
    }

    public void unblockUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBlocked(false);
            userRepository.save(user);
        }
    }
}
