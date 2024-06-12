package S15_19.backend.repository;

import S15_19.backend.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

    Optional<EventEntity> findEventEntityByTitle(String title);

}
