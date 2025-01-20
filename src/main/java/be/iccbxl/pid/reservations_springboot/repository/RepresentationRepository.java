package be.iccbxl.pid.reservations_springboot.repository;


import be.iccbxl.pid.reservations_springboot.model.Representation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentationRepository extends JpaRepository<Representation, Long> {
    Representation findById(long id);
}
