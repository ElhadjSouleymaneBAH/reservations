package be.iccbxl.pid.reservations_springboot.repository;

import be.iccbxl.pid.reservations_springboot.model.ArtistType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArtistTypeRepository extends JpaRepository<ArtistType, Long> {

    List<ArtistType> findByArtist_Lastname(String lastname);
    List<ArtistType> findByArtist_Firstname(String firstname);
    List<ArtistType> findByArtist_Id(Long artistId);
}
