package kr.taehoon.exercise.dto.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class BackExerciseRequest {

    private long id;
    private double weight;
    @NotNull
    private int count;
}
