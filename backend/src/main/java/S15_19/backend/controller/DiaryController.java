package S15_19.backend.controller;

import S15_19.backend.exception.DiaryNotFoundException;
import S15_19.backend.exception.UserNotFoundException;
import S15_19.backend.model.DTO.DiaryDTO;
import S15_19.backend.model.DiaryEntity;
import S15_19.backend.service.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/create") // /create/?userID=1
    public ResponseEntity<DiaryEntity> createDiary(@RequestBody DiaryDTO diaryDTO, @RequestParam Integer userID) throws UserNotFoundException {
        DiaryEntity savedDiary = diaryService.createDiary(diaryDTO, userID);
        return new ResponseEntity<>(savedDiary, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DiaryEntity>> listAllDiaries() {
        return new ResponseEntity<>(diaryService.listAllDiaries(), HttpStatus.OK);
    }

    @PutMapping("/update/{diaryID}")
    public ResponseEntity<DiaryEntity> updateDiary(@RequestBody DiaryDTO diaryDTO, @PathVariable Integer diaryID) throws DiaryNotFoundException {
        return new ResponseEntity<>(diaryService.updateDiary(diaryDTO, diaryID), HttpStatus.OK);
    }
}
