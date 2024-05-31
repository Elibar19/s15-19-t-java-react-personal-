package S15_19.backend.model.DTO;

import S15_19.backend.model.Category;
import S15_19.backend.model.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequestDTO {

    private Integer id;

    private Category category;

    private Type type;

    private String title;

    private String content;

    private LocalDate publicationDate;
}
