package be.iccbxl.pid.reservations_springboot.repository;

import be.iccbxl.pid.reservations_springboot.model.ArtistType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistTypeRepository extends JpaRepository<ArtistType, Long> {
    ArtistType findById(long id);
    ArtistType findByName(String name);
}
