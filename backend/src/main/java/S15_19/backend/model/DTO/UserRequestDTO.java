package S15_19.backend.model.DTO;

import S15_19.backend.model.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String country;
    private Role role;

}
