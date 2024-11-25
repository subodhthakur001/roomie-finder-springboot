package com.example.roomate_finder.service;

import com.example.roomate_finder.dao.UserRepository;
import com.example.roomate_finder.dto.request.UserProfileRequest;
import com.example.roomate_finder.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private final UserRepository userRepository;

    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserProfileRequest request){
        User dbUser = new User();
        dbUser.setFullName(request.getFullName());
        dbUser.setLocation(request.getLocation());
        dbUser.setEmail(request.getEmail());
        dbUser.setPhoneNumber(request.getPhoneNumber());
        dbUser.setBudget(request.getBudget());
        dbUser.setMoveInDate(request.getMoveInDate());
        dbUser.setPreferencesDescription(request.getPreferencesDescription());
        dbUser.setLifestyle(request.getLifestyle());
        dbUser.setDescription(request.getDescription());
        return userRepository.save(dbUser);
    }
}
