package com.AK.DoctorAppointmentBookingApp.Repository;

import com.AK.DoctorAppointmentBookingApp.Models.BloodGroup;
import com.AK.DoctorAppointmentBookingApp.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientRepo extends JpaRepository<Patient,Integer> {
    Patient findFirstByPatientEmail(String email);

    List<Patient> findByPatientBloodGroup(BloodGroup bloodGroup);
}
