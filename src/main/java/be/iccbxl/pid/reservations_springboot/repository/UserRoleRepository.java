package be.iccbxl.pid.reservations_springboot.repository;


import be.iccbxl.pid.reservations_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import be.iccbxl.pid.reservations_springboot.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRoleRepository findById(long id);
}

