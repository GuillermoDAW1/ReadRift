package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.auth.SignupRequest;
import com.proyecto.ReadRift.models.user.Role;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.repositories.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminRequestServiceImpl adminRequestServiceImpl;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDetailsRepository.findByEmail(email);
    }

    public User create(SignupRequest signupRequest) {
        User user = new User(
                null,
                signupRequest.getFirstname(),
                signupRequest.getLastname(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()),
                Role.USER
        );
        this.save(user);
        return user;
    }

    public User save(User user) {
        return userDetailsRepository.save(user);
    }

    public User updateUser(String email, User user) {
        User userUpdated = this.loadUserByUsername(email);
        userUpdated.setFirstname(user.getFirstname());
        userUpdated.setLastname(user.getLastname());
        userUpdated.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsRepository.save(userUpdated);
        return userUpdated;
    }

    public boolean existsUser(String email) {
        return userDetailsRepository.existsByEmail(email);
    }

    public User findById(Long id) {
        return userDetailsRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userDetailsRepository.findAll();
    }

    public void requestAdmin(String email) {
        adminRequestServiceImpl.requestAdmin(email);
    }
}
