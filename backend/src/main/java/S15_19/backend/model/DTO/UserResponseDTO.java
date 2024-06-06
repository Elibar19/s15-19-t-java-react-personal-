package S15_19.backend.model.DTO;

import S15_19.backend.model.DiaryEntity;
import S15_19.backend.model.PublicationEntity;
import S15_19.backend.model.Role;
import S15_19.backend.model.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String country;
    private Role role;
    private List<PublicationEntity> publications;
    private List<DiaryEntity> diaries;

    public UserResponseDTO(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.userName = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.country = userEntity.getCountry();
        this.role = userEntity.getRole();
        this.publications = userEntity.getPublications();
        this.diaries = userEntity.getDiaries();
    }
}
