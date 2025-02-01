package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.ArtistType;
import be.iccbxl.pid.reservations_springboot.repository.ArtistTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistTypeService {

    @Autowired
    private ArtistTypeRepository repository;

    //  Récupérer toutes les relations ArtistType
    public List<ArtistType> getAllArtistTypes() {
        return repository.findAll();
    }

    // Trouver un ArtistType par ID avec Optional
    public Optional<ArtistType> getArtistTypeById(Long id) {
        return repository.findById(id);
    }

    //  Ajouter une relation entre un Artiste et un Type
    public ArtistType addArtistType(ArtistType artistType) {
        return repository.save(artistType);
    }

    //  Supprimer une relation ArtistType
    public void removeArtistType(Long id) {
        repository.deleteById(id);
    }
}
