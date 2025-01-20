package be.iccbxl.pid.reservations_springboot.service;


import be.iccbxl.pid.reservations_springboot.model.Representation;
import be.iccbxl.pid.reservations_springboot.repository.RepresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentationService {
    @Autowired
    private RepresentationRepository repository;

    public List<Representation> getAllRepresentations() {
        return repository.findAll();
    }

    public Representation getRepresentation(long id) {
        return repository.findById(id);
    }

    public void addRepresentation(Representation representation) {
        repository.save(representation);
    }

    public void updateRepresentation(long id, Representation representation) {
        repository.save(representation);
    }

    public void deleteRepresentation(long id) {
        repository.deleteById(id);
    }
}
