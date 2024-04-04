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

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDetailsRepository.findByEmail(email);
    }
    public User create(SignupRequest signupRequest){
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

    public User save(User user){
        return userDetailsRepository.save(user);
    }

    public User updateUser(String email, User user) {
        User userUpdated = this.loadUserByUsername(email);
        userUpdated.setFirstname(user.getFirstname());
        userUpdated.setLastname(user.getLastname());
        userDetailsRepository.save(userUpdated);
        return userUpdated;
    }
    public boolean exixtsUser(String email){ return userDetailsRepository.existsByEmail(email); }

    public User findById(Long id){
        return userDetailsRepository.findById(id).get();
    }
    public List<User> findAll(){
        return userDetailsRepository.findAll();
    }
}
