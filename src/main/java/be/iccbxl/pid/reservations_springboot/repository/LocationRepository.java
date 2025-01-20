package be.iccbxl.pid.reservations_springboot.repository;



import be.iccbxl.pid.reservations_springboot.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findById(long id);
    List<Location> findByCity(String city);
}
