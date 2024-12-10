package be.iccbxl.pid.reservationsspringboot.service;


import be.iccbxl.pid.reservationsspringboot.model.Locality;
import be.iccbxl.pid.reservationsspringboot.repository.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocalityService {
    @Autowired
    private LocalityRepository repository;

    public List<Locality> getAll() {
        List<Locality> localities = new ArrayList<>();
        repository.findAll().forEach(localities::add);
        return localities;
    }

    public Locality get(Long id) {
        Optional<Locality> locality = repository.findById(id);
        return locality.orElse(null);
    }

    public void save(Locality locality) {
        repository.save(locality);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
