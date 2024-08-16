package com.tgbot.admin.service;

import com.tgbot.admin.database.entity.AdminUser;
import com.tgbot.admin.database.interfaces.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserRepository.findByUsername(username);
        if (adminUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(adminUser.getUsername(), adminUser.getPassword(), Collections.emptyList());
    }
}