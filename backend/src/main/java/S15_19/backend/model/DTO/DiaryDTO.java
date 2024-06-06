package S15_19.backend.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryDTO {
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fecha;
    private String contenido;
}
