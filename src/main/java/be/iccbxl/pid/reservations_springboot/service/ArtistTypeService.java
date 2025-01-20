package be.iccbxl.pid.reservations_springboot.service;



import be.iccbxl.pid.reservations_springboot.model.ArtistType;
import be.iccbxl.pid.reservations_springboot.repository.ArtistTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistTypeService {
    @Autowired
    private ArtistTypeRepository repository;

    public List<ArtistType> getAllArtistTypes() {
        return repository.findAll();
    }

    public ArtistType getArtistType(long id) {
        return repository.findById(id);
    }

    public void addArtistType(ArtistType artistType) {
        repository.save(artistType);
    }

    public void updateArtistType(long id, ArtistType artistType) {
        repository.save(artistType);
    }

    public void deleteArtistType(long id) {
        repository.deleteById(id);
    }
}
