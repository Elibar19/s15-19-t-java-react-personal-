package S15_19.backend.service;

import S15_19.backend.model.DTO.EventDTO;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    Optional<List<EventDTO>> listAllEvents();

    Optional<EventDTO> findEventByTitle(String title);

    Optional<EventDTO> findEventById(Integer id);

    Optional<EventDTO> createEvent(Integer userId, EventDTO eventDTO) throws Exception;

    Optional<EventDTO> deleteEvent(Integer id) throws Exception;

    Optional<EventDTO> updateEvent(EventDTO eventDTO) throws Exception;


}
