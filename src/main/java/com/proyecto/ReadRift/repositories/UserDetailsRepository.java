package com.proyecto.ReadRift.repositories;

import com.proyecto.ReadRift.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, Long> {
     User findByEmail(String email);
}
