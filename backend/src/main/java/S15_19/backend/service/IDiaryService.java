package S15_19.backend.service;

import S15_19.backend.exception.DiaryNotFoundException;
import S15_19.backend.exception.UserNotFoundException;
import S15_19.backend.model.DTO.DiaryDTO;
import S15_19.backend.model.DiaryEntity;

import java.util.List;

public interface IDiaryService {
    DiaryEntity createDiary(DiaryDTO diaryEntityDTO, Integer userID) throws UserNotFoundException;

    List<DiaryEntity> listAllDiaries();

    DiaryEntity updateDiary(DiaryDTO diaryDTO, Integer diaryID) throws DiaryNotFoundException;
}
