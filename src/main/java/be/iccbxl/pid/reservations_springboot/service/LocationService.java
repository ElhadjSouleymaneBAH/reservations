package be.iccbxl.pid.reservations_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservations_springboot.model.Location;
import be.iccbxl.pid.reservations_springboot.repository.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocation(Long id) { // Correction du nom de la méthode
        Optional<Location> location = locationRepository.findById(id);
        return location.orElse(null); // Retourne null si non trouvé
    }

    public void addLocation(Location location) { // Correction du nom pour cohérence
        locationRepository.save(location);
    }

    public void updateLocation(Long id, Location location) {
        if (locationRepository.existsById(id)) {
            locationRepository.save(location);
        }
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
