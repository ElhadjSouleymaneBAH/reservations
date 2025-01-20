package be.iccbxl.pid.reservations_springboot.service;



import be.iccbxl.pid.reservations_springboot.model.Location;
import be.iccbxl.pid.reservations_springboot.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;

    public List<Location> getAllLocations() {
        return repository.findAll();
    }

    public Location getLocation(long id) {
        return repository.findById(id);
    }

    public void addLocation(Location location) {
        repository.save(location);
    }

    public void updateLocation(long id, Location location) {
        repository.save(location);
    }

    public void deleteLocation(long id) {
        repository.deleteById(id);
    }
}
