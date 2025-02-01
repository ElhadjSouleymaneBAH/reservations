package be.iccbxl.pid.reservations_springboot.repository;

import be.iccbxl.pid.reservations_springboot.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findById(Long id);
    List<Show> findByTitleContaining(String title);
}
