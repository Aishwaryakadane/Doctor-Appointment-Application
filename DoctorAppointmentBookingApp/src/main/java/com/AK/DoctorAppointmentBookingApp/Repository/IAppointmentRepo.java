package com.AK.DoctorAppointmentBookingApp.Repository;

import com.AK.DoctorAppointmentBookingApp.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appointment,Long> {
}
