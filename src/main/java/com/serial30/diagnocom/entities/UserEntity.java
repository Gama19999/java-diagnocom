package com.serial30.diagnocom.entities;

import com.serial30.diagnocom.configuration.S;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = S.Entities.JPQL_USERS)
@Table(name = S.Entities.TABLE_USERS)
@Getter @Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = S.Entities.USER_ID, insertable = false, updatable = false)
    private UUID userId;

    @Column(name = S.Entities.USERNAME, nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = S.Entities.PASSWORD, nullable = false, length = 50)
    private String password;

    @Column(name = S.Entities.EMAIL, unique = true)
    private String email;

    @Column(name = S.Entities.CREATED_AT, insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = S.Entities.LAST_LOGIN)
    private Timestamp lastLogin;
}
