package kr.taehoon.exercise.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
@Data
public class BackExerciseResponse {

    private long id;
    private double weight;
    private int count;
    private ZonedDateTime createTime;
}
