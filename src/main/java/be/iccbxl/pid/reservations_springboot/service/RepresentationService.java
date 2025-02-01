package be.iccbxl.pid.reservations_springboot.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservations_springboot.model.Representation;
import be.iccbxl.pid.reservations_springboot.repository.RepresentationRepository;

import java.util.List;

@Service
public class RepresentationService {
    @Autowired
    private RepresentationRepository representationRepository;

    public List<Representation> getAllRepresentations() {
        return representationRepository.findAll();
    }

    public Representation getRepresentationById(Long id) {
        return representationRepository.findById(id).orElse(null);
    }

    public void saveRepresentation(Representation representation) {
        representationRepository.save(representation);
    }

    public void deleteRepresentation(Long id) {
        representationRepository.deleteById(id);
    }
}

