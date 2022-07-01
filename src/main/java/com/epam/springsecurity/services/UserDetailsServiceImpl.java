package com.epam.springsecurity.services;


import com.epam.springsecurity.models.AuthGroup;
import com.epam.springsecurity.models.User;
import com.epam.springsecurity.models.UserPrincipal;
import com.epam.springsecurity.repositories.AuthGroupRepository;
import com.epam.springsecurity.repositories.UserRepository;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private AuthGroupRepository authGroupRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("can't find user with email" + username);
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByEmail(username);

        return new UserPrincipal(user, authGroups);
    }
}
