package S15_19.backend.model.DTO;

import S15_19.backend.model.EventEntity;
import S15_19.backend.model.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    @Positive
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    public EventDTO(EventEntity eventEntity) {
        this.id = eventEntity.getId();
        this.eventType = eventEntity.getEventType();
        this.title = eventEntity.getTitle();
        this.description = eventEntity.getDescription();
        this.date = eventEntity.getDate();
    }
}
