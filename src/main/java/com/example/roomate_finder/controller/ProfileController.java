package com.example.roomate_finder.controller;

import com.example.roomate_finder.dto.request.UserProfileRequest;
import com.example.roomate_finder.dto.response.BaseResponse;
import com.example.roomate_finder.model.User;
import com.example.roomate_finder.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ProfileController {
    private final UserProfileService userProfileService;

    @Autowired
    public ProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createUserProfile(@Valid @RequestBody UserProfileRequest request){
        User createdUserProfile = userProfileService.createUser(request);
        BaseResponse response = new BaseResponse(createdUserProfile, "Profile Added successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
