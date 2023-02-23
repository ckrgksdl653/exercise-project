package kr.taehoon.exercise.service.impl;

import kr.taehoon.exercise.dto.request.BackExerciseRequest;
import kr.taehoon.exercise.dto.response.BackExerciseResponse;
import kr.taehoon.exercise.entity.BackExercise;
import kr.taehoon.exercise.entity.MusculerStrength;
import kr.taehoon.exercise.entity.UpperBody;
import kr.taehoon.exercise.repository.BackRepository;
import kr.taehoon.exercise.repository.MusculerStrengthRepository;
import kr.taehoon.exercise.repository.UpperBodyRepository;
import kr.taehoon.exercise.service.BackExerciseService;
import kr.taehoon.exercise.util.Back;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BackExerciseServiceImpl implements BackExerciseService {
    private final BackRepository backRepository;
    private final MusculerStrengthRepository musculerStrengthRepository;
    private final UpperBodyRepository upperBodyRepository;

    @Override
    public List<BackExerciseResponse> getBackExerciseInfo() {
        return backRepository.findAll().stream()
                .map(backExercise -> backExerciseToBackExerciseResponse(backExercise)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public boolean createBackExerciseInfo(BackExerciseRequest request, Back back) {
        BackExercise backExercise = backExerciseRequestToBackExercise(request, back);
        backRepository.save(backExercise);
        return true;
    }

    @Transactional
    @Override
    public boolean updateBackExerciseInfo(long id, BackExerciseRequest request, Back back) {
        BackExercise originBackExercise = backRepository.findById(id).orElseThrow();
        originBackExercise.setCount(request.getCount());
        originBackExercise.setWeight(request.getWeight());
        originBackExercise.setTypeId(back.getType());
        return true;
    }

    @Transactional
    @Override
    public boolean deleteBackExerciseInfo(long id) {
        BackExercise backExercise = backRepository.findById(id).orElseThrow();
        backRepository.delete(backExercise);
        return true;
    }

    private BackExerciseResponse backExerciseToBackExerciseResponse(BackExercise backExercise) {
        BackExerciseResponse backExerciseResponse = BackExerciseResponse.builder()
                .id(backExercise.getId())
                .count(backExercise.getCount())
                .weight(backExercise.getWeight())
                .build();
        return backExerciseResponse;
    }

    private BackExercise backExerciseRequestToBackExercise(BackExerciseRequest backExerciseRequest, Back back) {
        MusculerStrength musculerStrength = MusculerStrength.builder().build();
        musculerStrengthRepository.save(musculerStrength);
        UpperBody upperBody = UpperBody.builder().musculerStrength(musculerStrength).build();
        upperBodyRepository.save(upperBody);
        BackExercise backExercise = BackExercise.builder()
                .count(backExerciseRequest.getCount())
                .weight(backExerciseRequest.getWeight())
                .typeId(back.getCode())
                .upperBody(upperBody)
                .build();
        return backExercise;
    }
}
