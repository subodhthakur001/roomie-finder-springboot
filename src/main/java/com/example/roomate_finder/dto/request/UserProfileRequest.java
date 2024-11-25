package com.example.roomate_finder.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileRequest {
    @JsonProperty("full_name")
    @NotBlank(message = "Full name is required and cannot be empty.")
    private String fullName;

    @NotBlank(message = "location is required and cannot be empty.")
    private String location;

    @Email(message = "Please provide a valid email address.")
    private String email;

    @JsonProperty("phone_number")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits.")
    private String phoneNumber;


    @Positive(message = "Budget must be a positive value.")
    private double budget;

    @Future(message = "Move-in date must be a future date.")
    @JsonProperty("move_in_date")
    private Date moveInDate;

    @Size(max = 500, message = "Preferences description must not exceed 500 characters.")
    @JsonProperty("preferences_description")
    private String preferencesDescription;

    @NotEmpty(message = "Lifestyle preferences must not be empty.")
    private List<String> lifestyle;

    @Size(max = 300, message = "Description must not exceed 300 characters.")
    private String description;

}
