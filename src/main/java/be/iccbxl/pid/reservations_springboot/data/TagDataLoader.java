package be.iccbxl.pid.reservations_springboot.data;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.model.Tag;
import be.iccbxl.pid.reservations_springboot.repository.ShowRepository;
import be.iccbxl.pid.reservations_springboot.repository.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TagDataLoader implements CommandLineRunner {

    private final TagRepository tagRepository;
    private final ShowRepository showRepository;

    public TagDataLoader(TagRepository tagRepository, ShowRepository showRepository) {
        this.tagRepository = tagRepository;
        this.showRepository = showRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (tagRepository.count() == 0) {
            Tag comedie = new Tag("comédie");
            Tag musique = new Tag("musique");
            Tag classique = new Tag("classique");

            tagRepository.save(comedie);
            tagRepository.save(musique);
            tagRepository.save(classique);

            // Associer à un show existant (exemple avec id 1 et 2)
            Optional<Show> show1 = showRepository.findById(1L);
            Optional<Show> show2 = showRepository.findById(2L);

            show1.ifPresent(show -> {
                show.addTag(comedie);
                show.addTag(musique);
                showRepository.save(show);
            });

            show2.ifPresent(show -> {
                show.addTag(classique);
                showRepository.save(show);
            });
        }
    }
}
