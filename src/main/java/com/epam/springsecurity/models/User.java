package com.epam.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    private long id;
    private String email;
    private String password;
    @Column(name = "is_non_locked")
    @JsonProperty("isNonLocked")
    private boolean isNonLocked;
    @Column(name = "last_success_login_timestamp")
    private long lastSuccessLoginTimestamp;
    @Column(name = "attempts_count")
    private int attemptsCount;
}
