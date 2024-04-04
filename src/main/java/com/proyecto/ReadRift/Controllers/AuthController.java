package com.proyecto.ReadRift.Controllers;

import java.util.Map;
import com.proyecto.ReadRift.auth.LoginRequest;
import com.proyecto.ReadRift.auth.JwtService;
import com.proyecto.ReadRift.auth.SignupRequest;
import com.proyecto.ReadRift.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<Map> login(@RequestBody LoginRequest loginRequest) {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    ));
        return ResponseEntity.ok(Map.of("token",
                    jwtService.createToken(authentication.getName()
                ))
        );
    }
//    @PostMapping("/signup")
//    public ResponseEntity<UserDetails> signup(@RequestBody SignupRequest signupRequest) {
//        return ResponseEntity.ok(
//                jwtService.createToken(authentication.getName())
//                userDetailsService.create(signupRequest) //pasar por mapper
//        );
//    }
}