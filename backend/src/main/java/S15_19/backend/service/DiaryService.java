package S15_19.backend.service;

import S15_19.backend.exception.DiaryNotFoundException;
import S15_19.backend.exception.UserNotFoundException;
import S15_19.backend.model.DTO.DiaryDTO;
import S15_19.backend.model.DiaryEntity;
import S15_19.backend.model.UserEntity;
import S15_19.backend.repository.DiaryRepository;
import S15_19.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DiaryService implements IDiaryService {
    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    public DiaryService(DiaryRepository diaryRepository, UserRepository userRepository) {
        this.diaryRepository = diaryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DiaryEntity createDiary(DiaryDTO diaryEntityDTO, Integer userID) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findById(userID).orElseThrow(() -> new UserNotFoundException("Usuario No Encontrado"));

        DiaryEntity newDiary = DiaryEntity.builder()
                .titulo(diaryEntityDTO.getTitulo())
                .contenido(diaryEntityDTO.getContenido())
                .fecha(new Date())
                .userEntity(userEntity)
                .build();

        DiaryEntity savedDiary = diaryRepository.save(newDiary);

        userEntity.getDiaries().add(savedDiary);
        userRepository.save(userEntity);

        return savedDiary;
    }

    @Override
    public List<DiaryEntity> listAllDiaries() {
        return diaryRepository.findAll();
    }

    @Override
    public DiaryEntity updateDiary(DiaryDTO diaryDTO, Integer diaryID) throws DiaryNotFoundException {
        Optional<DiaryEntity> optionalDiary = diaryRepository.findById(diaryID);
        if (optionalDiary.isPresent()) {
            DiaryEntity diaryEntity = optionalDiary.get();
            // Solo actualiza la fecha si el contenido fue modificado
            if (!diaryEntity.getContenido().equals(diaryDTO.getContenido())) {
                diaryEntity.setContenido(diaryDTO.getContenido());
                diaryEntity.setFecha(new Date());
            }
            return diaryRepository.save(diaryEntity);
        } else {
            throw new DiaryNotFoundException("Diario "+diaryID+" no encontrado");
        }
    }
}
