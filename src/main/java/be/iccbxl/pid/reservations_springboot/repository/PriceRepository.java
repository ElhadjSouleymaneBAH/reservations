package be.iccbxl.pid.reservations_springboot.repository;


import be.iccbxl.pid.reservations_springboot.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
    Price findById(long id);
}

