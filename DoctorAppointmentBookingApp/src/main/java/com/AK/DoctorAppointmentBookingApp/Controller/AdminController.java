package com.AK.DoctorAppointmentBookingApp.Controller;


import com.AK.DoctorAppointmentBookingApp.Models.BloodGroup;
import com.AK.DoctorAppointmentBookingApp.Models.Doctor;
import com.AK.DoctorAppointmentBookingApp.Models.Patient;
import com.AK.DoctorAppointmentBookingApp.Service.DoctorService;
import com.AK.DoctorAppointmentBookingApp.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class AdminController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @GetMapping("patients")
    public List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }

    @PostMapping("doctor")
    public String addDoctor(@RequestBody Doctor newDoctor)
    {
        return doctorService.addDoctor(newDoctor);
    }

    @GetMapping("patients/bloodGroup/{bloodGroup}")
    public List<Patient> getAllPatientsByBloodGroup(@PathVariable BloodGroup bloodGroup)
    {
        return patientService.getAllPatientsByBloodGroup(bloodGroup);
    }


}
