package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.Troupe;
import be.iccbxl.pid.reservations_springboot.repository.TroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TroupeService {

    @Autowired
    private TroupeRepository troupeRepository;

    public List<Troupe> getAllTroupes() {
        return (List<Troupe>) troupeRepository.findAll();
    }

    public Troupe getTroupe(Long id) {
        return troupeRepository.findById(id).orElse(null);
    }

    public Troupe addTroupe(Troupe troupe) {
        return troupeRepository.save(troupe);
    }

    public Troupe updateTroupe(Long id, Troupe troupe) {
        if (troupeRepository.existsById(id)) {
            troupe.setId(id);
            return troupeRepository.save(troupe);
        }
        return null;
    }

    public void deleteTroupe(Long id) {
        troupeRepository.deleteById(id);
    }
}