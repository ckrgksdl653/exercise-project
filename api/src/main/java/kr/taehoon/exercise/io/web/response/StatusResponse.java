package kr.taehoon.exercise.io.web.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "데이터 입력, 업데이트, 및 제거에 대한 응답을 전달하는 Dto")
@Builder
@Getter
public class StatusResponse {

    @Schema(description = "성공 실패 여부", defaultValue = "false", allowableValues = {"true", "false"})
    private boolean result;

}