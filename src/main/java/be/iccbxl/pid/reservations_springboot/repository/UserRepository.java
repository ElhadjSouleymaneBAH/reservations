package be.iccbxl.pid.reservations_springboot.repository;


import be.iccbxl.pid.reservations_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByEmail(String email);
}
