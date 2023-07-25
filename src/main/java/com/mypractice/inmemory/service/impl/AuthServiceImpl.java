package com.mypractice.inmemory.service.impl;

import com.mypractice.inmemory.dto.AuthRequestDto;
import com.mypractice.inmemory.service.AuthService;
import com.mypractice.inmemory.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public Map<String, String> authRequest(AuthRequestDto authRequestDto) {
       final var authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.userName(), authRequestDto.password()));
       final var userDetails =  (UserDetails) authenticate.getPrincipal();
       return   getToken(userDetails);
    }

    public Map<String, String> getToken( UserDetails userDetails) {
        final var roles = userDetails.getAuthorities();
        final var username = userDetails.getUsername();
        final var token = jwtService.generateToken(Map.of("role", roles), username);
        return Map.of("token", token);
    }
}
