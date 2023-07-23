package app.shootingstar.ShootingStarERP.Security.controller;

import javax.validation.Valid;

import app.shootingstar.ShootingStarERP.Security.model.AuthRequest;
import app.shootingstar.ShootingStarERP.Security.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.shootingstar.ShootingStarERP.Security.util.JwtTokenUtil;
import app.shootingstar.ShootingStarERP.Security.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthApi {
    @Autowired AuthenticationManager authManager;
    @Autowired JwtTokenUtil jwtUtil;



    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getUsername(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        }
    }
}
