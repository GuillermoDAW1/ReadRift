package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.repositories.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserDetailsRepository userDetailsRepository;

    @Override
    public List<User> findAllUsers() {
        return userDetailsRepository.findAll();
    }

    @Override
    public void deleteUserById(Long userId) {
        userDetailsRepository.deleteById(userId);
    }
}
