package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.user.Role;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitialDataCreationService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createInitialData() {
        if (!userDetailsRepository.existsByEmail("admin@admin.com")) {
            User superAdmin = new User();
            superAdmin.setFirstname("Super");
            superAdmin.setLastname("Admin");
            superAdmin.setEmail("admin@admin.com");
            superAdmin.setPassword(passwordEncoder.encode("adminpassword"));
            superAdmin.setRole(Role.SUPER_ADMIN);
            userDetailsRepository.save(superAdmin);
        }
    }
}