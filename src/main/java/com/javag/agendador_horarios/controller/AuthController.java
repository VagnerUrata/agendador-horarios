package com.javag.agendador_horarios.controller;

import com.javag.agendador_horarios.dto.LoginRequest;
import com.javag.agendador_horarios.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getUsername());

        return ResponseEntity.ok(token);
    }
}
//        if ("admin".equals(request.getUsername()) &&
//            "123".equals(request.getPassword())){
//
//            String token = jwtService.generateToken(request.getUsername());
//            return ResponseEntity.ok(token);
//        }
//
//        return ResponseEntity.status(401).body("Usuário ou senha inválidos");
//    }
//}
