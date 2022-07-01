package com.epam.springsecurity.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auth_user_group")
public class AuthGroup {
    @Id
    @Column(name = "auth_user_group_id")
    private long id;
    private String email;
    @Column(name = "auth_group")
    private String authGroup;
}
