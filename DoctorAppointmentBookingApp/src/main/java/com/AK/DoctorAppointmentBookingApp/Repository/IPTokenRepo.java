package com.AK.DoctorAppointmentBookingApp.Repository;

import com.AK.DoctorAppointmentBookingApp.Models.PatientAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPTokenRepo extends JpaRepository<PatientAuthenticationToken,Integer> {
    PatientAuthenticationToken findFirstByTokenValue(String tokenValue);
}
