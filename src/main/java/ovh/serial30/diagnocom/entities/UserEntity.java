package ovh.serial30.diagnocom.entities;

import ovh.serial30.diagnocom.configuration.Const;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = Const.Entities.JPQL_USERS)
@Table(name = Const.Entities.TABLE_USERS)
@Getter @Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = Const.Entities.USER_ID, insertable = false, updatable = false)
    private UUID userId;

    @Column(name = Const.Entities.USERNAME, nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = Const.Entities.PASSWORD, nullable = false, length = 50)
    private String password;

    @Column(name = Const.Entities.EMAIL, unique = true)
    private String email;

    @Column(name = Const.Entities.CREATED_AT, insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = Const.Entities.LAST_LOGIN)
    private Timestamp lastLogin;
}
