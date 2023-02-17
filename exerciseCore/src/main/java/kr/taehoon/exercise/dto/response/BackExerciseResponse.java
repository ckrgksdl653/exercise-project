package kr.taehoon.exercise.dto.response;

import lombok.Data;

@Data
public class BackExerciseResponse {

    private long id;
    private double weight;
    private int count;
    private long startTime;
    private long endTime;
}
