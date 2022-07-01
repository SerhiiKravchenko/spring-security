package com.epam.springsecurity.listeners;

import com.epam.springsecurity.models.User;
import com.epam.springsecurity.repositories.UserRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessEventListener implements
        ApplicationListener<AuthenticationSuccessEvent> {

    private UserRepository userRepository;

    public AuthenticationSuccessEventListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(final AuthenticationSuccessEvent e) {
        String name = e.getAuthentication().getName();
        User user = userRepository.findByEmail(name);
        if (user == null) {
            throw new RuntimeException("No such user!");
        } else {
            user.setAttemptsCount(0);
            user.setLastSuccessLoginTimestamp(System.currentTimeMillis());
            user.setNonLocked(true);
        }

        userRepository.save(user);
    }
}
