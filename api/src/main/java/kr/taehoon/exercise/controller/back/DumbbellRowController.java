package kr.taehoon.exercise.controller.back;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Parameter;
import kr.taehoon.exercise.io.web.request.CreateRequest;
import kr.taehoon.exercise.io.web.request.UpdateRequest;
import kr.taehoon.exercise.io.web.response.BasicInformationResponse;
import kr.taehoon.exercise.io.web.response.StatusResponse;
import kr.taehoon.exercise.service.BackExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Api(tags = {"Dumbbell Row API"})
@RestController
@RequestMapping("/api/v1/back/dumbbell-row")
public class DumbbellRowController {

    private final BackExerciseService backExerciseService;

    @ApiOperation(value = "dumbbell row과 관련된 데이터를 입력받는 기능"
            , notes = "사용자로부터 한 세트당 수행한 횟수와 무게를 입력받도록 한다. 여기서 무게는 중량을 이용했을 때만 받도록 한다. " +
            "중량 설정을 하지 않은 경우에는 0으로 받거나, 해당 데이터를 보내지 않는다. " +
            "정상적으로 처리하면 result 객체를 전달하는데, result에는 데이터가 정상적으로 삽입이 되었는지에 대한 여부를 전달하도록 한다.")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "한 세트에 대한 dumbbell row 값이 정상적으로 입력됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @PostMapping()
    public ResponseEntity<StatusResponse> createDumbbellRow(@RequestBody CreateRequest request) {
        return ResponseEntity.created(URI.create("/api/v1/back/dumbbell-row"))
                .body(StatusResponse.builder().result(true).build());
    }

    @ApiOperation(value = "dumbbell row과 관련된 전체 데이터를 조회하는 기능"
            , notes = "사용자로부터 첫 기록부터 마지막 기록까지 기입된 dumbbell-row에 대한 모든 정보를 반환하도록 한다. id, weight, count가 담긴 리스트를 반환한다. id는 세트 id를 의미한다.")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "전체 dumbbell row에 대한 값이 조회됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @GetMapping()
    public ResponseEntity<List<BasicInformationResponse>> readAllDumbbellRowData() {
        return ResponseEntity.ok(Arrays.asList(BasicInformationResponse.builder().build()));
    }

    @ApiOperation(value = "dumbbell row과 관련된 특정 세트 데이터를 조회하는 기능"
            , notes = "특정 id에 대응되는 상세한 정보를 반환하도록 한다. 반환하는 정보는 id, weight, count, start_time, end_time이다.")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "특정 dumbbell row에 대한 값이 조회됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BasicInformationResponse> readDumbbellRowDataById(
            @Parameter(name = "id", description = "세트의 id")
            @PathVariable long id) {
        return ResponseEntity.ok(BasicInformationResponse.builder().build());
    }

    @ApiOperation(value = "dumbbell row했을 때 최고 횟수를 조회하는 기능"
            , notes = "사용자로부터 첫 기록부터 마지막 기록 사이에 기입된 dumbbell-row 세트 중에서 가장 많이 수행한 횟수가 있는 정보를 반환하도록 한다. 반환되는 정보에는 id, weight, count, start_time, end_time, date 가 포함된다. (나중에는 해당 세트를 수행한 날짜에서 기록한 모든 dumbbell row정보를 가져오는 것도 고려)")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "dumbbell row 최고 횟수에 대한 값이 조회됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @GetMapping("/max-count")
    public ResponseEntity<BasicInformationResponse> readDumbbellRowMaxCountData() {
        return ResponseEntity.ok(BasicInformationResponse.builder().build());
    }

    @ApiOperation(value = "dumbbell row했을 때 최저 횟수를 조회하는 기능"
            , notes = "사용자로부터 첫 기록부터 마지막 기록 사이에 기입된 dumbbell-row 세트 중에서 가장 적게 수행한 횟수가 있는 정보를 반환하도록 한다. 반환되는 정보에는 id, weight, count, start_time, end_time, date 가 포함된다. (나중에는 해당 세트를 수행한 날짜에서 기록한 모든 dumbbell row정보를 가져오는 것도 고려)")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "dumbbell row 최고 횟수에 대한 값이 조회됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @GetMapping("/min-count")
    public ResponseEntity<BasicInformationResponse> readDumbbellRowMinCountData() {
        return ResponseEntity.ok(BasicInformationResponse.builder().build());
    }

    @ApiOperation(value = "dumbbell row했을 때 최고 중량을 조회하는 기능"
            , notes = "사용자로부터 첫 기록부터 마지막 기록 사이에 기입된 dumbbell-row 세트 중에서 가장 무거운 중량을 친 정보를 반환하도록 한다. 반환되는 정보에는 id, weight, count, start_time, end_time, date 가 포함된다. (나중에는 해당 세트를 수행한 날짜에서 기록한 모든 dumbbell row정보를 가져오는 것도 고려)")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "dumbbell row 최고 중량에 대한 값이 조회됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @GetMapping("/max-weight")
    public ResponseEntity<BasicInformationResponse> readDumbbellRowMaxWeightData() {
        return ResponseEntity.ok(BasicInformationResponse.builder().build());
    }

    @ApiOperation(value = "dumbbell row했을 때 최저 중량을 조회하는 기능"
            , notes = "사용자로부터 첫 기록부터 마지막 기록 사이에 기입된 dumbbell-row 세트 중에서 가장 가벼운 중량을 친 정보를 반환하도록 한다. 반환되는 정보에는 id, weight, count, start_time, end_time, date 가 포함된다. (나중에는 해당 세트를 수행한 날짜에서 기록한 모든 dumbbell row정보를 가져오는 것도 고려)")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "dumbbell row 최저 중량에 대한 값이 조회됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @GetMapping("/min-weight")
    public ResponseEntity<BasicInformationResponse> readDumbbellRowMinWeightData() {
        return ResponseEntity.ok(BasicInformationResponse.builder().build());
    }

    @ApiOperation(value = "dumbbell row 데이터를 업데이트하는 기능"
            , notes = "특정 세트 기록에 저장된 정보를 수정하는 기능이다. path variable로 특정 세트의 id를 받게 되며, input dto로는 수정할 weight, count, start_time, end_time을 받도록 한다. 정상적으로 처리하면 result 객체를 전달하는데, result에는 데이터가 정상적으로 삽입이 되었는지에 대한 여부를 전달하도록 한다.")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "dumbbell row 데이터가 정상적으로 업데이트 됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<StatusResponse> updateDumbbellRowMinWeightData(
            @Parameter(name = "id", description = "세트의 id")
            @PathVariable long id,
            @RequestBody UpdateRequest request) {
        return ResponseEntity.ok(StatusResponse.builder().result(false).build());
    }

    @ApiOperation(value = "dumbbell row 데이터를 제거하는 기능"
            , notes = "특정 세트 기록을 제거한다. path variable로 id를 넘겨받으면 해당 id에 대해 삭제하도록 한다.")
    @ApiParam()
    @ApiResponses({
            @ApiResponse(code = 200, message = "dumbbell row 데이터가 정상적으로 제거 됨"),
            @ApiResponse(code = 500, message = "server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> deleteDumbbellRowMinWeightData(
            @Parameter(name = "id", description = "세트의 id")
            @PathVariable long id) {
        return ResponseEntity.ok(StatusResponse.builder().result(false).build());
    }


}
