package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.user.User;

import java.util.List;

public interface AdminService {

    List<User> findAllUsers();

    void deleteUserById(Long userId);
    /*
    void approveAdminRequest(Long userId);
    void rejectAdminRequest(Long userId);*/
}
