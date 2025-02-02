package be.iccbxl.pid.reservationsspringboot.repository;

import be.iccbxl.pid.reservations_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
    List<User> findByLastname(String lastname);
    Optional<User> findByEmail(String email);
}
