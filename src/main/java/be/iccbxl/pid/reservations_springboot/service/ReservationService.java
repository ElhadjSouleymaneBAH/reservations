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
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée avec l'ID : " + id));
    }

    public void addReservation(Reservation reservation) {
        repository.save(reservation);
    }

    public void updateReservation(long id, Reservation reservation) {
        if (repository.existsById(id)) {
            repository.save(reservation);
        } else {
            throw new RuntimeException("Impossible de mettre à jour : Réservation non trouvée avec l'ID : " + id);
        }
    }

    public void deleteReservation(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Impossible de supprimer : Réservation non trouvée avec l'ID : " + id);
        }
    }
}
