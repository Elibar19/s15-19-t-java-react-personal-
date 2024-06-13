package S15_19.backend.model.DTO;

import S15_19.backend.model.Category;
import S15_19.backend.model.PublicationEntity;
import S15_19.backend.model.Type;

import java.time.LocalDate;

public class PublicationResponseDTO {

    private Integer id;
    private Category category;

    private Type type;

    private String title;

    private String content;

    private LocalDate publicationDate;

    public PublicationResponseDTO(PublicationEntity publicationEntity){
        this.id = publicationEntity.getId();
        this.category = publicationEntity.getCategory();
        this.type = publicationEntity.getType();
        this.title = publicationEntity.getTitle();
        this.content = publicationEntity.getContent();
        this.publicationDate = publicationEntity.getPublicationDate();
    }
}
