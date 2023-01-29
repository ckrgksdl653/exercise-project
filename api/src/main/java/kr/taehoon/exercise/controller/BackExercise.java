package kr.taehoon.exercise.controller;

import kr.taehoon.exercise.service.BackExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/back")
public class BackExercise {

    private final BackExerciseService backExerciseService;

    @GetMapping("/get/simple")
    public boolean readBackInformation() {
        return backExerciseService.read();
    }

}
