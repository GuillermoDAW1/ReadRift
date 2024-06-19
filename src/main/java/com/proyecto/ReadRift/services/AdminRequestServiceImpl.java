package com.proyecto.ReadRift.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminRequestServiceImpl {

    private final Set<String> adminRequests = new HashSet<>();

    public void requestAdmin(String email) { adminRequests.add(email);
    }
    public void approveAdminRequest(String email) {
        adminRequests.remove(email);
    }

    public void rejectAdminRequest(String email) {
        adminRequests.remove(email);
    }

    public boolean hasRequestedAdmin(String email) {
        return adminRequests.contains(email);
    }

}
