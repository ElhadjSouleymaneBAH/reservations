package be.iccbxl.pid.reservations_springboot.service;


import be.iccbxl.pid.reservations_springboot.model.Reservation;
import be.iccbxl.pid.reservations_springboot.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Reservation getReservation(long id) {
        return repository.findById(id);
    }

    public void addReservation(Reservation reservation) {
        repository.save(reservation);
    }

    public void updateReservation(long id, Reservation reservation) {
        repository.save(reservation);
    }

    public void deleteReservation(long id) {
        repository.deleteById(id);
    }
}


