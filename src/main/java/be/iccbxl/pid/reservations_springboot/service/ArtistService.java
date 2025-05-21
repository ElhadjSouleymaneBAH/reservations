package be.iccbxl.pid.reservations_springboot.service;

import java.util.ArrayList;
import java.util.List;
import be.iccbxl.pid.reservations_springboot.model.Artist;
import be.iccbxl.pid.reservations_springboot.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        artistRepository.findAll().forEach(artists::add);
        return artists;
    }

    public Artist getArtist(long id) {
        return artistRepository.findById(id).orElse(null); // Gestion de l'Optional
    }

    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist); // Retourne l'artiste sauvegardé
    }

    public Artist updateArtist(long id, Artist artist) {
        if (artistRepository.existsById(id)) {
            artist.setId(id); // S'assure que l'ID est correct
            return artistRepository.save(artist);
        }
        return null; // Retourne null si l'artiste n'existe pas
    }

    public void deleteArtist(long id) {
        artistRepository.deleteById(id);
    }
}