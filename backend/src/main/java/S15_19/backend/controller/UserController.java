package S15_19.backend.controller;

import S15_19.backend.exception.UserNotFoundException;
import S15_19.backend.model.DTO.UserResponseDTO;
import S15_19.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUserByID(@PathVariable Integer id) {
        try {
            UserResponseDTO userResponseDTO = userService.findByID(id);
            return ResponseEntity.ok(userResponseDTO);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
