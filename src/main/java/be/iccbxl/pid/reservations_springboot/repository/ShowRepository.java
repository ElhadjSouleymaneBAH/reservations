package be.iccbxl.pid.reservations_springboot.repository;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("SELECT s FROM Show s WHERE :tag NOT MEMBER OF s.tags")
    List<Show> findShowsWithoutTag(@Param("tag") Tag tag);

    List<Show> findByTitleContainingIgnoreCase(String title);
}
