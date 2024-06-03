package S15_19.backend.repository;

import S15_19.backend.model.PublicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<PublicationEntity, Integer> {

    Optional<PublicationEntity> findPublicationEntityByTitle(String title);
}
