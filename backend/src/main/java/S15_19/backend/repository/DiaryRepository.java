package S15_19.backend.repository;

import S15_19.backend.model.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Integer> {
}
