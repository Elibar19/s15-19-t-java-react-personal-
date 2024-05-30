package S15_19.backend.service;

import S15_19.backend.model.DTO.UserRequestDTO;
import S15_19.backend.model.DTO.UserResponseDTO;
import S15_19.backend.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<List<UserResponseDTO>> listAll();
    String deleteUser(Integer id) throws Exception;
    Optional<UserResponseDTO> updateUser(Integer id, UserRequestDTO userRequestDTO) throws Exception;

    Optional<List<UserResponseDTO>> findByFirstName(String firstName);
    Optional<UserResponseDTO> findByUserName(String userName);
    Optional<List<UserResponseDTO>> findByLastName(String lastName);
    Optional<List<UserResponseDTO>> findByCountry(String country);
}
