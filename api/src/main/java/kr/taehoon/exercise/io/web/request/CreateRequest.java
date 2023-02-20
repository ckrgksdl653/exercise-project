package kr.taehoon.exercise.io.web.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "데이터 입력을 요청하는 Dto")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CreateRequest {

    @Schema(description = "중량", defaultValue = "0")
    private int weight;

    @Schema(description = "횟수", defaultValue = "0")
    private int count;

}