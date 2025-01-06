package com.goodbuy.googbuylogin.login.login;

import com.goodbuy.googbuylogin.login.UserInfoDto;
import com.goodbuy.googbuylogin.login.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    public String register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists!");
        }
        UserInfoDto user = new UserInfoDto();
        user.setUserName(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String login(String username, String password) {
        Optional<UserInfoDto> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty() || !passwordEncoder.matches(password, userOpt.get().getPassword())) {
            throw new IllegalArgumentException("Invalid username or password!");
        }
        return jwtUtils.generateToken(username);
    }

    public void deleteAccount(String username) {
        userRepository.deleteByUsername(username);
    }
}
