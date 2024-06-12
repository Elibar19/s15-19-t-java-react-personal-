package S15_19.backend.service;

import S15_19.backend.model.DTO.EventDTO;
import S15_19.backend.model.EventEntity;
import S15_19.backend.model.UserEntity;
import S15_19.backend.repository.EventRepository;
import S15_19.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService implements IEventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<List<EventDTO>> listAllEvents() {
        List<EventEntity> eventEntities = eventRepository.findAll();
        return Optional.of(eventEntities.stream().map(EventDTO::new).collect(Collectors.toList()));
    }


    public Optional<EventDTO> findEventByTitle(String title) {
        Optional<EventEntity> event = eventRepository.findEventEntityByTitle(title);
        return event.map(EventDTO::new);
    }


    public Optional<EventDTO> findEventById(Integer id) {
        Optional<EventEntity> event = eventRepository.findById(id);
        return event.map(EventDTO::new);
    }

    public Optional<EventDTO> createEvent(Integer userId, EventDTO eventDTO) throws Exception {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new Exception("User with id: " + userId + " does not exist.");
        }

        EventEntity newEvent = EventEntity.builder()
                .title(eventDTO.getTitle())
                .description(eventDTO.getDescription())
                .eventType(eventDTO.getEventType())
                .date(eventDTO.getDate())
                .build();
        eventRepository.save(newEvent);

        UserEntity author = optionalUser.get();
        List<EventEntity> userEvents = author.getEvents();
        userEvents.add(newEvent);
        author.setEvents(userEvents);
        userRepository.save(author);

        return Optional.of(new EventDTO(newEvent));
    }

    public Optional<EventDTO> deleteEvent(Integer id) throws Exception {
        Optional<EventEntity> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isEmpty()){
            throw new Exception("Event with id " + id + " does not exist.");
        }
        EventEntity event = optionalEvent.get();

        UserEntity owner = event.getOwner();
        List<EventEntity> userEvents = owner.getEvents();
        userEvents.remove(event);
        owner.setEvents(userEvents);
        userRepository.save(owner);

        eventRepository.delete(event);

        return Optional.of(new EventDTO(event));
    }

    public Optional<EventDTO> updateEvent(EventDTO eventDTO) throws Exception {
        Optional<EventEntity> optionalEvent = eventRepository.findById(eventDTO.getId());
        if(optionalEvent.isEmpty()){
            throw new Exception("Publication with id " + eventDTO.getId() + " does not exist.");
        }
        EventEntity event = optionalEvent.get();

        if(eventDTO.getTitle() != null)
            event.setTitle(eventDTO.getTitle());

        if(eventDTO.getDescription() != null)
            event.setDescription(eventDTO.getDescription());

        if(eventDTO.getEventType() != null)
            event.setEventType(eventDTO.getEventType());

        if(eventDTO.getDate() != null)
            event.setDate(eventDTO.getDate());

        eventRepository.save(event);
        return Optional.of(new EventDTO(event));
    }
}
