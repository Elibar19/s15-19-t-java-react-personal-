package S15_19.backend.model.DTO;

import S15_19.backend.model.Category;
import S15_19.backend.model.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequestDTO {

    @Positive
    private Integer id;

    @NotNull
    private Category category;

    @NotNull
    private Type type;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String content;

    @NotNull
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate publicationDate;
}
