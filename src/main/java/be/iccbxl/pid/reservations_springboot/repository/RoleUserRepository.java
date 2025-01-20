package be.iccbxl.pid.reservations_springboot.repository;


import be.iccbxl.pid.reservations_springboot.model.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    RoleUser findById(long id);
}

