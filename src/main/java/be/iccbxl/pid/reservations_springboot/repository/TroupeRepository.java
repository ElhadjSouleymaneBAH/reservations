package be.iccbxl.pid.reservations_springboot.repository;

import be.iccbxl.pid.reservations_springboot.model.Troupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TroupeRepository extends JpaRepository<Troupe, Long> {
    Troupe findByName(String name);
}