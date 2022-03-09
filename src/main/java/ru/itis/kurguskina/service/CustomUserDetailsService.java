package ru.itis.kurguskina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.repository.UserRepository;
import ru.itis.kurguskina.security.CustomUserDetails;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);
        return CustomUserDetails.fromModel(user);
    }
}
