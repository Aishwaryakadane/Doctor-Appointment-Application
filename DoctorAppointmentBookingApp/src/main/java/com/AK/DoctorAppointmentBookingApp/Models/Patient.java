package com.AK.DoctorAppointmentBookingApp.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Patient.class,property = "patientId")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @NotBlank
    private String patientName;
    @Pattern(regexp = "^\\d{10}$")
    private String patientContact;
    @Enumerated(value = EnumType.STRING)
    private Gender patientGender;
    private BloodGroup patientBloodGroup;
    @Email
    private String patientEmail;
    private String patientPassword;
    private String patientAddress;
    private LocalDateTime patientDateOdBirth;

    @OneToMany(mappedBy = "patient")
    List<Appointment> appointment;

}
