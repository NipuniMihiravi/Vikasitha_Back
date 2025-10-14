package com.example.demo.Controller;

import com.example.demo.Model.Maintenance;
import com.example.demo.Service.MaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maintenance")
@CrossOrigin(origins = "*")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    // ➕ Add new maintenance
    @PostMapping
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    // 🔍 Get all maintenance
    @GetMapping
    public List<Maintenance> getAllMaintenance() {
        return maintenanceService.getAllMaintenance();
    }

    // 🔍 Get maintenance by member ID
    @GetMapping("/member/{memberId}")
    public List<Maintenance> getMaintenanceByMember(@PathVariable String memberId) {
        return maintenanceService.getMaintenanceByMemberId(memberId);
    }

    // 🔍 Get maintenance by ID
    @GetMapping("/{id}")
    public Optional<Maintenance> getMaintenanceById(@PathVariable String id) {
        return maintenanceService.getMaintenanceById(id);
    }

    // 🗑️ Delete maintenance
    @DeleteMapping("/{id}")
    public String deleteMaintenance(@PathVariable String id) {
        maintenanceService.deleteMaintenance(id);
        return "Maintenance record deleted successfully!";
    }
}
