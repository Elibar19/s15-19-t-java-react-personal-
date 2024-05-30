package S15_19.backend.auth;

import S15_19.backend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static S15_19.backend.model.Role.USER;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
  /*private String firstName;
    private String lastName;
    private String country;
    private String email;*/
    private String password;
    private Role role;
}
