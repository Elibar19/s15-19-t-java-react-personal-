package S15_19.backend.service;

import S15_19.backend.auth.AuthResponse;
import S15_19.backend.auth.LoginRequest;
import S15_19.backend.auth.RegisterRequest;
import S15_19.backend.exception.UserNotFoundException;
import S15_19.backend.jwt.JwtService;
import S15_19.backend.model.DTO.UserRequestDTO;
import S15_19.backend.model.DTO.UserResponseDTO;
import S15_19.backend.model.Role;
import S15_19.backend.model.UserEntity;
import S15_19.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;


    @Override
    public Optional<List<UserResponseDTO>> listAll() {
        List<UserEntity> users = userRepository.findAll();
        return Optional.of(users.stream().map(UserResponseDTO::new).collect(Collectors.toList()));
    }

    public UserResponseDTO findByID(Integer id) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario con id: " + id + " no encontrado."));
        UserResponseDTO userFound = new UserResponseDTO(userEntity);
        return userFound;
    }

    @Override
    public Optional<List<UserResponseDTO>> findByFirstName(String firstName) {
        List<UserEntity> user = userRepository.findByFirstName(firstName);
        return Optional.of(user.stream().map(UserResponseDTO::new).collect(Collectors.toList()));
    }

    @Override
    public Optional<UserResponseDTO> findByUserName(String userName) {
        Optional<UserEntity> users = userRepository.findByUsername(userName);
        return users.map(UserResponseDTO::new);
    }

    @Override
    public Optional<List<UserResponseDTO>> findByLastName(String lastName) {
        List<UserEntity> users = userRepository.findByLastName(lastName);
        return Optional.of(users.stream().map(UserResponseDTO::new).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<UserResponseDTO>> findByCountry(String country) {
        List<UserEntity> users = userRepository.findByCountry(country);
        return Optional.of(users.stream().map(UserResponseDTO::new).collect(Collectors.toList()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteUser(Integer id) throws Exception {
        try {
            Optional<UserEntity> user = userRepository.findById(id);
            if (user.isPresent()) {
                UserEntity userDelete = user.get();
                userDelete.isActive(false);
                userRepository.save(userDelete);
            } else {
                throw new Exception("No se ha encontrado el usuario");
            }
            return "Usuario eliminado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al eliminar el usuario con ID: " + id, e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<UserResponseDTO> updateUser(Integer id, UserRequestDTO userUpdate) throws Exception {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity == null) throw new Exception("El usuario no se encuentra");
        try {
            if (userEntity != null) {
                if (userUpdate.getUserName() != null) userEntity.setUsername((userUpdate.getUserName()));
                if (userUpdate.getFirstName() != null) userEntity.setFirstName((userUpdate.getFirstName()));
                if (userUpdate.getLastName() != null) userEntity.setLastName(userUpdate.getLastName());
                if (userUpdate.getEmail() != null) userEntity.setEmail(userUpdate.getEmail());
                if (userUpdate.getCountry() != null) userEntity.setCountry(userUpdate.getCountry());

                userRepository.save(userEntity);

                return Optional.of(new UserResponseDTO(userEntity));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al actualizar usaurio");
        }
        return Optional.empty();
    }

    /* Se crea el metodo login. Se recupera el usuario y se autentica buscandolo en la bd y se devuelve el usuario con el JWT. */
    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            return AuthResponse.builder()
                    .message("El nombre de usuario o la contraseña no coinciden")
                    .build();
        }
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .message("Login Success")
                .build();
    }

    /* Creamos el metodo para registrar usuarios. Se devuelve el JWT del nuevo usuario. */
    public AuthResponse register(RegisterRequest request) {
        UserEntity userEntity = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .country(request.getCountry())
                .build();

        userRepository.save(userEntity);
        return AuthResponse.builder()
                .token(jwtService.getToken(userEntity))
                .build();
    }

}
