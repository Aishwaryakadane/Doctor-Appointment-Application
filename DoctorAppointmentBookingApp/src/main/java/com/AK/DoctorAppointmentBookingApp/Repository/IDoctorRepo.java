package com.AK.DoctorAppointmentBookingApp.Repository;

import com.AK.DoctorAppointmentBookingApp.Models.Doctor;
import com.AK.DoctorAppointmentBookingApp.Models.Qualification;
import com.AK.DoctorAppointmentBookingApp.Models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctorRepo extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByDocQualificationOrDocSpecialization(Qualification qual, Specialization spec);
}
