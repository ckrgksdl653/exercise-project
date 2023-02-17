package kr.taehoon.exercise.dto.response;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BackExerciseResponse {

    private long id;
    private double weight;
    private int count;
    private ZonedDateTime createTime;
}
