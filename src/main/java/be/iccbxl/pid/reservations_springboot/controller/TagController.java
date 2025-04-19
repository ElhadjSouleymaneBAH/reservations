package be.iccbxl.pid.reservations_springboot.controller;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.model.Tag;
import be.iccbxl.pid.reservations_springboot.repository.ShowRepository;
import be.iccbxl.pid.reservations_springboot.repository.TagRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagRepository tagRepository;
    private final ShowRepository showRepository;

    public TagController(TagRepository tagRepository, ShowRepository showRepository) {
        this.tagRepository = tagRepository;
        this.showRepository = showRepository;
    }

    @GetMapping
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @GetMapping("/show/{showId}")
    public ResponseEntity<?> getTagsByShow(@PathVariable Long showId) {
        Optional<Show> show = showRepository.findById(showId);
        return show.map(s -> ResponseEntity.ok(s.getTags()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/show/{showId}/add")
    @Transactional
    public ResponseEntity<?> addTagToShow(@PathVariable Long showId, @RequestBody Map<String, String> body) {
        String tagLabel = body.get("tag");

        Optional<Show> showOpt = showRepository.findById(showId);
        if (showOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Show show = showOpt.get();
        Tag tag = tagRepository.findByTag(tagLabel).orElseGet(() -> tagRepository.save(new Tag(tagLabel)));

        show.addTag(tag);
        showRepository.save(show);

        return ResponseEntity.ok().body("Tag ajouté avec succès !");
    }
}
