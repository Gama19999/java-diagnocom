package ovh.serial30.diagnocom.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ovh.serial30.diagnocom.entities.ResultEntity;

import java.util.UUID;

@Repository
public interface ResultRepository extends CrudRepository<ResultEntity, UUID> {
}
