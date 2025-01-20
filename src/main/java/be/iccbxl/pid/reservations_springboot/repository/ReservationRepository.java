package be.iccbxl.pid.reservations_springboot.repository;

import be.iccbxl.pid.reservations_springboot.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findById(long id);
    List<Reservation> findByUserId(long userId);
}
