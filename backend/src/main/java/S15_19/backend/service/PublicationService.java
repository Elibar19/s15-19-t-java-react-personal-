package S15_19.backend.service;

import S15_19.backend.model.DTO.PublicationRequestDTO;
import S15_19.backend.model.DTO.PublicationResponseDTO;
import S15_19.backend.model.PublicationEntity;
import S15_19.backend.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;


    public Optional<List<PublicationResponseDTO>> listAllPublications(){
        List<PublicationEntity> publicationEntities = publicationRepository.findAll();
        return Optional.of(publicationEntities.stream().map(PublicationResponseDTO::new).collect(Collectors.toList()));
    }

    public Optional<PublicationResponseDTO> findPublicationByTitle(String title){
        Optional<PublicationEntity> publication = publicationRepository.findPublicationEntityByTitle(title);
        return publication.map(PublicationResponseDTO::new);
    }

    public Optional<PublicationResponseDTO> findPublicationById(Integer id) {
        Optional<PublicationEntity> publication = publicationRepository.findById(id);
        return publication.map(PublicationResponseDTO::new);
    }

    public Optional<PublicationResponseDTO> createPublication(PublicationRequestDTO publicationRequestDTO){
        PublicationEntity newPublication = PublicationEntity.builder()
                .title(publicationRequestDTO.getTitle())
                .type(publicationRequestDTO.getType())
                .category(publicationRequestDTO.getCategory())
                .content(publicationRequestDTO.getContent())
                .publicationDate(publicationRequestDTO.getPublicationDate())
                .build();

        publicationRepository.save(newPublication);
        return Optional.of(new PublicationResponseDTO(newPublication));
    }


    @Transactional
    public Optional<PublicationResponseDTO> deletePublication(Integer id) throws Exception {
        Optional<PublicationEntity> publication = publicationRepository.findById(id);
        if(publication.isEmpty()){
            throw new Exception("Publication wit id" + id + "does not exist.");
        }
        publicationRepository.delete(publication.get());
        return Optional.of(new PublicationResponseDTO(publication.get()));
    }

    @Transactional
    public Optional<PublicationResponseDTO> updatePublication(PublicationRequestDTO publicationRequestDTO) throws Exception {
        Optional<PublicationEntity> optionalPublication = publicationRepository.findById(publicationRequestDTO.getId());
        if(optionalPublication.isEmpty()){
            throw new Exception("Publication wit id" + publicationRequestDTO.getId() + "does not exist.");
        }
        PublicationEntity publication = optionalPublication.get();
        if(publicationRequestDTO.getTitle() != null)
            publication.setTitle(publicationRequestDTO.getTitle());

        if(publicationRequestDTO.getCategory() != null)
            publication.setCategory(publicationRequestDTO.getCategory());

        if(publicationRequestDTO.getContent() != null)
            publication.setContent(publicationRequestDTO.getContent());

        publicationRepository.save(publication);
        return Optional.of(new PublicationResponseDTO(publication));
    }
}
