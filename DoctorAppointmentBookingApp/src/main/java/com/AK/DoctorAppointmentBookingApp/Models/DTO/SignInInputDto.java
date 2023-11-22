package com.AK.DoctorAppointmentBookingApp.Models.DTO;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInputDto {

    @Email
    private String email;
    private String password;
}
