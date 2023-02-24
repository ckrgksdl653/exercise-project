package kr.taehoon.exercise.service;

import kr.taehoon.exercise.dto.request.BackExerciseRequest;
import kr.taehoon.exercise.dto.response.BackExerciseResponse;
import kr.taehoon.exercise.util.Back;

import java.util.List;

public interface BackExerciseService {

    List<BackExerciseResponse> getBackExerciseInfo();

    boolean createBackExerciseInfo(BackExerciseRequest request, Back back);

    boolean updateBackExerciseInfo(long id, BackExerciseRequest request, Back back);

    boolean deleteBackExerciseInfo(long id);


}
