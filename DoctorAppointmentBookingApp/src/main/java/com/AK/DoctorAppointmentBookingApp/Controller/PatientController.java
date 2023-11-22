package com.AK.DoctorAppointmentBookingApp.Controller;

import com.AK.DoctorAppointmentBookingApp.Models.DTO.AuthenticationInputDto;
import com.AK.DoctorAppointmentBookingApp.Models.DTO.ScheduleAppointmentDto;
import com.AK.DoctorAppointmentBookingApp.Models.DTO.SignInInputDto;
import com.AK.DoctorAppointmentBookingApp.Models.Doctor;
import com.AK.DoctorAppointmentBookingApp.Models.Patient;
import com.AK.DoctorAppointmentBookingApp.Models.Qualification;
import com.AK.DoctorAppointmentBookingApp.Models.Specialization;
import com.AK.DoctorAppointmentBookingApp.Service.AppointmentService;
import com.AK.DoctorAppointmentBookingApp.Service.DoctorService;
import com.AK.DoctorAppointmentBookingApp.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorService doctorService;

    @PostMapping("patient/signUp")
    public String patientSignUp(@Valid @RequestBody Patient signUp){
        return patientService.patientSignUp(signUp);
    }
    @PostMapping("patient/signIn")
    public String patientSignIn(@Valid @RequestBody SignInInputDto signIn){
        return patientService.patientSignIn(signIn);
    }

    @DeleteMapping("patient/signOut")
    public String patientSignOut(@Valid @RequestBody AuthenticationInputDto authenticateTokenDto){
        return patientService.patientSignOut(authenticateTokenDto);
    }

    @PostMapping("patient/appointment/schedule")
    public String scheduleAppointment(@RequestBody ScheduleAppointmentDto scheduleAppointmentDTO)
    {
        return appointmentService.scheduleAppointment(scheduleAppointmentDTO.getAuthInfo(),scheduleAppointmentDTO.getAppointment());
    }

    @DeleteMapping("patient/appointment/{appointmentId}/cancel")
    public String cancelAppointment(@RequestBody AuthenticationInputDto authInfo, @PathVariable Long appointmentId)
    {
        return appointmentService.cancelAppointment(authInfo,appointmentId);
    }

    @GetMapping("doctors/qualification/{qual}/or/specialization/{spec}")
    public List<Doctor> getDoctorsByQualificationOrSpec(@RequestBody AuthenticationInputDto authInfo, @PathVariable Qualification qual, @PathVariable Specialization spec)
    {
        return doctorService.getDoctorsByQualificationOrSpec(authInfo,qual,spec);
    }
}
