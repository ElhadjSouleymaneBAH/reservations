package be.iccbxl.pid.reservations_springboot.repository;


import be.iccbxl.pid.reservations_springboot.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Show findById(long id);
    List<Show> findByTitleContaining(String title);
}

