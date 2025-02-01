package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository repository;

    public List<Show> getAllShows() {
        return repository.findAll();
    }

    public Show getShow(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void addShow(Show show) {
        repository.save(show);
    }

    public void updateShow(Long id, Show show) {
        repository.save(show);
    }

    public void deleteShow(Long id) {
        repository.deleteById(id);
    }

    public List<Show> searchShowsByTitle(String title) {
        return repository.findByTitleContaining(title);
    }
}
