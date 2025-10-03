package com.example.demo.Controller;

import com.example.demo.Model.MemberBilling;
import com.example.demo.Model.Registration;
import com.example.demo.Service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "*")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // GET all registrations
    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }
    @GetMapping("/member/{memberId}")
    public ResponseEntity<Registration> getRegistrationByMemberId(@PathVariable String memberId) {
        return registrationService.getByMemberId(memberId)
                .stream()
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET registration by ID
    @GetMapping("/{id}")
    public Optional<Registration> getRegistrationById(@PathVariable String id) {
        return registrationService.getRegistrationById(id);
    }

    // POST create new registration
    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationService.saveRegistration(registration);
    }

    // PUT update registration
    @PutMapping("/{id}")
    public Registration updateRegistration(@PathVariable String id, @RequestBody Registration updatedRegistration) {
        return registrationService.updateRegistration(id, updatedRegistration);
    }

    // DELETE registration
    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable String id) {
        registrationService.deleteRegistration(id);
    }
}
