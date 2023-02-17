package kr.taehoon.exercise.service;

import kr.taehoon.exercise.dto.request.BackExerciseRequest;
import kr.taehoon.exercise.dto.response.BackExerciseResponse;

import java.util.List;

public interface BackExerciseService {

    List<BackExerciseResponse> getBackExerciseInfo();

    boolean createBackExerciseInfo(BackExerciseRequest request);

    boolean updateBackExerciseInfo(BackExerciseRequest request);

    boolean deleteBackExerciseInfo(long id);


}
