package S15_19.backend.repository;

import S15_19.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByFirstName(String firstName);
    Optional<UserEntity> findByUsername(String userName);
    List<UserEntity> findByLastName(String lastName);
    List<UserEntity> findByCountry(String country);
}
