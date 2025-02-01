package be.iccbxl.pid.reservations_springboot.repository;

import be.iccbxl.pid.reservations_springboot.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
    Optional<Locality> findById(long id); // Correction du type de retour
}
