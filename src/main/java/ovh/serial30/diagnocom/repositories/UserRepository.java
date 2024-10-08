package ovh.serial30.diagnocom.repositories;

import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {

    @Query(value = "from USERS u where u.username = :username")
    UserEntity findByUsername(@Param(Const.Entities.USERNAME) String username);
}
