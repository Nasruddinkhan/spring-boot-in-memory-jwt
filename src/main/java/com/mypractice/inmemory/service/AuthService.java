package com.mypractice.inmemory.service;

import com.mypractice.inmemory.dto.AuthRequestDto;

import java.util.Map;

public interface AuthService {
     Map<String, String> authRequest(AuthRequestDto authRequestDto);

}
