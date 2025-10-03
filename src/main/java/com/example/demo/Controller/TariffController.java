package com.example.demo.Controller;

import com.example.demo.Model.Tariff;
import com.example.demo.Service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tariff")
@CrossOrigin(origins = "*")
public class TariffController {

    @Autowired
    private TariffService tariffService;

    @GetMapping
    public List<Tariff> getAllTariffs() {
        return tariffService.getAllTariffs();
    }

    @GetMapping("/current")
    public Tariff getCurrentTariff() {
        return tariffService.getLatestActiveTariff();
    }


    @GetMapping("/{id}")
    public Optional<Tariff> getTariffById(@PathVariable String id) {
        return tariffService.getTariffById(id);
    }

    @PostMapping
    public Tariff createTariff(@RequestBody Tariff tariff) {
        return tariffService.saveTariff(tariff);
    }

    @PutMapping("/{id}")
    public Tariff updateTariff(@PathVariable String id, @RequestBody Tariff tariff) {
        tariff.setId(id);
        return tariffService.saveTariff(tariff);
    }

    @DeleteMapping("/{id}")
    public void deleteTariff(@PathVariable String id) {
        tariffService.deleteTariff(id);
    }

    @GetMapping("/unit/{unit}")
    public Tariff getTariffForUnit(@PathVariable Integer unit) {
        return tariffService.getTariffForUnit(unit);
    }
}
