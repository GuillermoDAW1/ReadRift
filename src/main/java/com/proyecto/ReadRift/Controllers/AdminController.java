package com.proyecto.ReadRift.Controllers;

import com.proyecto.ReadRift.models.user.Role;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.services.AdminRequestServiceImpl;
import com.proyecto.ReadRift.services.AdminService;
import com.proyecto.ReadRift.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final AdminRequestServiceImpl adminRequestServiceImpl;
    private final UserDetailsServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.findAllUsers());
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.loadUserByUsername(authentication.getName());
        User userToDelete = userService.findById(userId);

        if (userToDelete.getRole() == Role.ADMIN && currentUser.getRole() != Role.SUPER_ADMIN) {
            return ResponseEntity.status(403).build();
        }

        adminService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/user/{userId}/approve")
    public ResponseEntity<Void> approveAdminRequest(@PathVariable Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.loadUserByUsername(authentication.getName());

        if (currentUser.getRole() != Role.SUPER_ADMIN) {
            return ResponseEntity.status(403).build(); // Forbidden
        }
        User user = userService.findById(userId);
        if (user != null && adminRequestServiceImpl.hasRequestedAdmin(user.getEmail())) {
            user.setRole(Role.ADMIN);
            adminRequestServiceImpl.approveAdminRequest(user.getEmail());
            userService.save(user);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/user/{userId}/reject")
    public ResponseEntity<Void> rejectAdminRequest(@PathVariable Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.loadUserByUsername(authentication.getName());

        if (currentUser.getRole() != Role.SUPER_ADMIN) {
            return ResponseEntity.status(403).build(); // Forbidden
        }
        User user = userService.findById(userId);
        if (user != null && adminRequestServiceImpl.hasRequestedAdmin(user.getEmail())) {
            adminRequestServiceImpl.rejectAdminRequest(user.getEmail());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/admin-requests")
    public ResponseEntity<List<User>> getAllAdminRequests() {
        List<User> adminRequests = userService.findAll().stream()
                .filter(user -> adminRequestServiceImpl.hasRequestedAdmin(user.getEmail()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(adminRequests);
    }
}
