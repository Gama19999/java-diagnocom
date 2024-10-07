package ovh.serial30.diagnocom.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.entities.ResultEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResultRepository extends CrudRepository<ResultEntity, UUID> {

    @Query(value = "from RESULTS r where r.userId = :user_id")
    List<ResultEntity> findByUserId(@Param(Const.Entities.USER_ID) UUID userId);
}
