package com.epam.springsecurity.listeners;

import com.epam.springsecurity.models.User;
import com.epam.springsecurity.repositories.UserRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private UserRepository userRepository;

    public AuthenticationFailureListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        String name = e.getAuthentication().getName();
        User user = userRepository.findByEmail(name);
        if (user == null) {
            throw new RuntimeException("No such user!");
        } else {
            if (user.getAttemptsCount() >= 3) {
                user.setNonLocked(false);
            } else user.setAttemptsCount(user.getAttemptsCount() + 1);
        }

        userRepository.save(user);
    }
}