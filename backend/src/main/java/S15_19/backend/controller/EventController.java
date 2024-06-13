package S15_19.backend.controller;

import S15_19.backend.model.DTO.EventDTO;
import S15_19.backend.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping()
    public Optional<List<EventDTO>> listAllEvents(){
        return eventService.listAllEvents();
    }

    @GetMapping(path="/findByTitle")
    public Optional<EventDTO> findEventByTitle(
            @RequestParam String title){
        return eventService.findEventByTitle(title);
    }

    @GetMapping(path="/{id}")
    public Optional<EventDTO> findEventById(
            @PathVariable("id") Integer id){
        return eventService.findEventById(id);
    }

    @PostMapping
    public Optional<EventDTO> createEvent(
            @RequestParam Integer userId,
            @RequestBody @Valid EventDTO eventDTO) throws Exception {
        return eventService.createEvent(userId, eventDTO);
    }

    @DeleteMapping()
    public Optional<EventDTO> deleteEvent(
            @RequestParam Integer id) throws Exception {
        return eventService.deleteEvent(id);
    }

    @PutMapping()
    public Optional<EventDTO> updateEvent(
            @RequestBody @Valid EventDTO eventDTO) throws Exception {
        return eventService.updateEvent(eventDTO);
    }

}
