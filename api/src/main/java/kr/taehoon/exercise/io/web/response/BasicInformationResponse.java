package kr.taehoon.exercise.io.web.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "데이터를 기본적으로 조회한 Dto")
@Builder
@Getter
public class BasicInformationResponse {

    @Schema(description = "세트 아이디", defaultValue = "0")
    private long id;

    @Schema(description = "중량", defaultValue = "0")
    private int weight;

    @Schema(description = "횟수", defaultValue = "0")
    private int count;

}