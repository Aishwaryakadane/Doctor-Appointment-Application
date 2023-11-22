package com.AK.DoctorAppointmentBookingApp.Service;


import com.AK.DoctorAppointmentBookingApp.Models.DTO.AuthenticationInputDto;
import com.AK.DoctorAppointmentBookingApp.Models.PatientAuthenticationToken;
import com.AK.DoctorAppointmentBookingApp.Repository.IPTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PTokenService {


    @Autowired
    IPTokenRepo ipTokenRepo;

    public void createToken(PatientAuthenticationToken token) {
        ipTokenRepo.save(token);
    }

    public void deleteToken(String tokenValue) {

        PatientAuthenticationToken token =  ipTokenRepo.findFirstByTokenValue(tokenValue);
        ipTokenRepo.delete(token);

    }

    public boolean authenticate(AuthenticationInputDto authInfo) {

        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        //find thr actual token -> get the connected patient -> get its email-> verify with passed email

        //return ipTokenRepo.findFirstByTokenValue(tokenValue).getPatient().getPatientEmail().equals(email);

        PatientAuthenticationToken token =  ipTokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getPatient().getPatientEmail().equals(email);
        }
        else
        {
            return false;
        }

    }
}
