package kr.taehoon.exercise.io.web.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "데이터 수정을 요청하는 Dto")
@Builder
@Getter
public class UpdateRequest {

    @Schema(description = "중량", defaultValue = "0")
    private int weight;

    @Schema(description = "횟수", defaultValue = "0")
    private int count;

}