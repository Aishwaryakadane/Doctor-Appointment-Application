package com.AK.DoctorAppointmentBookingApp.Models.DTO;

import com.AK.DoctorAppointmentBookingApp.Models.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleAppointmentDto {

    AuthenticationInputDto authInfo;
    Appointment appointment;
}
