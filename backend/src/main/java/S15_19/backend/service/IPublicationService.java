package S15_19.backend.service;

import S15_19.backend.model.DTO.PublicationRequestDTO;
import S15_19.backend.model.DTO.PublicationResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IPublicationService {

    Optional<List<PublicationResponseDTO>> listAllPublications();

    Optional<PublicationResponseDTO> findPublicationByTitle(String title);

    Optional<PublicationResponseDTO> findPublicationById(Integer id);

    Optional<PublicationResponseDTO> createPublication(Integer userId, PublicationRequestDTO publicationRequestDTO) throws Exception;

    Optional<PublicationResponseDTO> deletePublication(Integer id) throws Exception;

    Optional<PublicationResponseDTO> updatePublication(PublicationRequestDTO publicationRequestDTO) throws Exception;

}
