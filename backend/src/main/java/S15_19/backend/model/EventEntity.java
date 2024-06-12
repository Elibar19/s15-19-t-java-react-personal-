package S15_19.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private String title;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


}
