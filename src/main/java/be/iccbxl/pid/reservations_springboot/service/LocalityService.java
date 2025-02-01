package be.iccbxl.pid.reservations_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservations_springboot.model.Locality;
import be.iccbxl.pid.reservations_springboot.repository.LocalityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    public List<Locality> getAllLocalities() {
        return localityRepository.findAll();
    }

    public Locality getLocalityById(long id) {
        Optional<Locality> locality = localityRepository.findById(id);
        return locality.orElse(null); // Retourne null si non trouvé
    }

    public Locality saveLocality(Locality locality) {
        return localityRepository.save(locality);
    }

    public boolean deleteLocality(long id) {
        if (localityRepository.existsById(id)) {
            localityRepository.deleteById(id);
            return true;
        }
        return false; // Retourne false si l'ID n'existe pas
    }
}
