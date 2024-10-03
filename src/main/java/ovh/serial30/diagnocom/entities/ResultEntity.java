package ovh.serial30.diagnocom.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ovh.serial30.diagnocom.configuration.Const;

import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = Const.Entities.JPQL_RESULTS)
@Table(name = Const.Entities.TABLE_RESULTS)
@Getter
@ToString
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = Const.Entities.RESULT_ID, insertable = false, updatable = false)
    private UUID resultId;

    @Setter
    @Column(name = Const.Entities.USER_ID, nullable = false)
    private UUID userId;

    @Setter
    @Column(name = Const.Entities.CONTENT, nullable = false)
    private String content;

    @Column(name = Const.Entities.CREATED_AT, insertable = false, updatable = false)
    private Timestamp createdAt;
}
