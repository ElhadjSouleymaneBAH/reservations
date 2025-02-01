package be.iccbxl.pid.reservations_springboot.repository;

import be.iccbxl.pid.reservations_springboot.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import be.iccbxl.pid.reservations_springboot.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

    LocationRepository findById(long id);
}


