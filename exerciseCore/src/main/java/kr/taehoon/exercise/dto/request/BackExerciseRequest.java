package kr.taehoon.exercise.dto.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BackExerciseRequest {

    private long id;
    private double weight;
    @NotNull
    private int count;
}
