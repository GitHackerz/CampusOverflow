package com.example.campusoverflow.auth;

import com.example.campusoverflow.auth.dto.LoginRequest;
import com.example.campusoverflow.auth.dto.LoginResponse;
import com.example.campusoverflow.auth.dto.RegistrationRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication API")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    ) throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("/activate-account")
    public ResponseEntity<?> activateAccount(
            @RequestParam String token
    ) {
        service.activateAccount(token);
        return ResponseEntity.ok().build();
    }

}
