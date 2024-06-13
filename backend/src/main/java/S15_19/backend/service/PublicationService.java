package S15_19.backend.service;

import S15_19.backend.model.DTO.PublicationRequestDTO;
import S15_19.backend.model.DTO.PublicationResponseDTO;
import S15_19.backend.model.PublicationEntity;
import S15_19.backend.model.UserEntity;
import S15_19.backend.repository.PublicationRepository;
import S15_19.backend.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicationService implements IPublicationService{

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private UserRepository userRepository;


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

    public Optional<PublicationResponseDTO> createPublication(Integer userId, PublicationRequestDTO publicationRequestDTO) throws Exception {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new Exception("User with id: " + userId + " does not exist.");
        }

        PublicationEntity newPublication = PublicationEntity.builder()
                .title(publicationRequestDTO.getTitle())
                .type(publicationRequestDTO.getType())
                .category(publicationRequestDTO.getCategory())
                .content(publicationRequestDTO.getContent())
                .publicationDate(publicationRequestDTO.getPublicationDate())
                .build();
        publicationRepository.save(newPublication);

        UserEntity author = optionalUser.get();
        List<PublicationEntity> userPublications = author.getPublications();
        userPublications.add(newPublication);
        author.setPublications(userPublications);
        userRepository.save(author);

        return Optional.of(new PublicationResponseDTO(newPublication));
    }


    @Transactional
    public Optional<PublicationResponseDTO> deletePublication(Integer id) throws Exception {
        Optional<PublicationEntity> optionalPublication = publicationRepository.findById(id);
        if(optionalPublication.isEmpty()){
            throw new Exception("Publication with id " + id + " does not exist.");
        }
        PublicationEntity publication = optionalPublication.get();

        UserEntity author = publication.getAuthor();
        List<PublicationEntity> userPublications = author.getPublications();
        userPublications.remove(publication);
        author.setPublications(userPublications);
        userRepository.save(author);

        publicationRepository.delete(publication);

        return Optional.of(new PublicationResponseDTO(publication));
    }

    @Transactional
    public Optional<PublicationResponseDTO> updatePublication(PublicationRequestDTO publicationRequestDTO) throws Exception {
        Optional<PublicationEntity> optionalPublication = publicationRepository.findById(publicationRequestDTO.getId());
        if(optionalPublication.isEmpty()){
            throw new Exception("Publication with id " + publicationRequestDTO.getId() + " does not exist.");
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
