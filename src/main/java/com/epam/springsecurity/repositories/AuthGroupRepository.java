package com.epam.springsecurity.repositories;

import com.epam.springsecurity.models.AuthGroup;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByEmail(String email);
}
