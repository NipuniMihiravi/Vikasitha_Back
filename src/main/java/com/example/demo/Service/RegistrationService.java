package com.example.demo.Service;

import com.example.demo.Model.MemberBilling;
import com.example.demo.Model.Registration;
import com.example.demo.Repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public List<Registration> getByMemberId(String memberId) {
        return registrationRepository.findByMemberId(memberId);
    }

    public Optional<Registration> getRegistrationById(String id) {
        return registrationRepository.findById(id);
    }

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Registration updateRegistration(String id, Registration updatedRegistration) {
        updatedRegistration.setId(id);
        return registrationRepository.save(updatedRegistration);
    }

    public void deleteRegistration(String id) {
        registrationRepository.deleteById(id);
    }


}
