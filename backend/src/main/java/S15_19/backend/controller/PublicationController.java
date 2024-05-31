package S15_19.backend.controller;

import S15_19.backend.model.DTO.PublicationRequestDTO;
import S15_19.backend.model.DTO.PublicationResponseDTO;
import S15_19.backend.model.DTO.UserResponseDTO;
import S15_19.backend.service.PublicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/publication")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @GetMapping()
    public Optional<List<PublicationResponseDTO>> listAllPublications(){
        return publicationService.listAllPublications();
    }

    @GetMapping(path="/findByTitle")
    public Optional<PublicationResponseDTO> findPublicationByTitle(@RequestParam String title){
        return publicationService.findPublicationByTitle(title);
    }

    @GetMapping(path="/findById")
    public Optional<PublicationResponseDTO> findPublicationById(@RequestParam Integer id){
        return publicationService.findPublicationById(id);
    }

    @PostMapping()
    public Optional<PublicationResponseDTO> createPublication(@RequestBody @Valid PublicationRequestDTO publicationRequestDTO){
        return publicationService.createPublication(publicationRequestDTO);
    }

    @DeleteMapping()
    public Optional<PublicationResponseDTO> deletePublication(@RequestParam Integer id) throws Exception {
        return publicationService.deletePublication(id);
    }

    @PutMapping()
    public Optional<PublicationResponseDTO> updatePublication(@RequestBody @Valid PublicationRequestDTO publicationRequestDTO) throws Exception {
        return publicationService.updatePublication(publicationRequestDTO);
    }

}
