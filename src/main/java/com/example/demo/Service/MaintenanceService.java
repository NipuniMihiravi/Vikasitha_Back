package com.example.demo.Service;

import com.example.demo.Model.Maintenance;
import com.example.demo.Repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    // ➕ Add new maintenance record
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    // 🔍 Get all maintenance records
    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    // 🔍 Get maintenance records by memberId
    public List<Maintenance> getMaintenanceByMemberId(String memberId) {
        return maintenanceRepository.findByMemberId(memberId);
    }

    // 🔍 Get maintenance record by ID
    public Optional<Maintenance> getMaintenanceById(String id) {
        return maintenanceRepository.findById(id);
    }

    // 🗑️ Delete maintenance record
    public void deleteMaintenance(String id) {
        maintenanceRepository.deleteById(id);
    }
}
