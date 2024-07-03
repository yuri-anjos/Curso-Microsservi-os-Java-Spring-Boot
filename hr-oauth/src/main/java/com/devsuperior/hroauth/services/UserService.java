package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.feign.UserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var user = userClient.findByEmail(s);
        if(user == null) {
            logger.error("Email not foud: {}", s);
            throw new UsernameNotFoundException("Email not found.");
        }
        return user;
    }
}
