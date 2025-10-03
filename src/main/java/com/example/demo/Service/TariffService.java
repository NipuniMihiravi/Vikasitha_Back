package com.example.demo.Service;

import com.example.demo.Model.Tariff;
import com.example.demo.Repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TariffService {

    @Autowired
    private TariffRepository tariffRepository;

    public List<Tariff> getAllTariffs() {
        return tariffRepository.findAll();
    }

    public Optional<Tariff> getTariffById(String id) {
        return tariffRepository.findById(id);
    }

    public Tariff saveTariff(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    public void deleteTariff(String id) {
        tariffRepository.deleteById(id);
    }

    public Tariff getTariffForUnit(Integer unit) {
        return tariffRepository.findFirstByMinUnitLessThanEqualAndMaxUnitGreaterThanEqualAndStatus(
                unit, unit, "ACTIVE");
    }
    public Tariff getLatestActiveTariff() {
        return tariffRepository.findTopByStatusOrderByTariffDateDesc("ACTIVE").orElse(null);
    }
}
