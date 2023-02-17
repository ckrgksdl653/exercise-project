package kr.taehoon.exercise.service.impl;

import kr.taehoon.exercise.dto.request.BackExerciseRequest;
import kr.taehoon.exercise.dto.response.BackExerciseResponse;
import kr.taehoon.exercise.entity.BackExercise;
import kr.taehoon.exercise.repository.BackExerciseRepository;
import kr.taehoon.exercise.service.BackExerciseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BackExerciseServiceImpl implements BackExerciseService {
    private final BackExerciseRepository backExerciseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BackExerciseResponse> getBackExerciseInfo() {
        return backExerciseRepository.findAll().stream()
                .map(backExercise -> modelMapper.map(backExercise, BackExerciseResponse.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public boolean createBackExerciseInfo(BackExerciseRequest request) {
        BackExercise backExercise = modelMapper.map(request, BackExercise.class);
        backExerciseRepository.save(backExercise);
        return true;
    }

    @Transactional
    @Override
    public boolean updateBackExerciseInfo(BackExerciseRequest request) {
        BackExercise backExercise = modelMapper.map(request, BackExercise.class);
        BackExercise originBackExercise = backExerciseRepository.findById(request.getId()).orElseThrow();
        originBackExercise.setCount(backExercise.getCount());
        originBackExercise.setWeight(backExercise.getWeight());
        return true;
    }

    @Transactional
    @Override
    public boolean deleteBackExerciseInfo(long id) {
        BackExercise backExercise = backExerciseRepository.findById(id).orElseThrow();
        backExerciseRepository.delete(backExercise);
        return true;
    }
}
