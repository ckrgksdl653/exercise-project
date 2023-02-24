package kr.taehoon.exercise.util;

import lombok.Getter;

@Getter
public enum Back {
    PULL_UP("풀업", "BACK01"),
    BAR_BELL_ROW("바벨로우", "BACK02"),
    DUMB_BELL_ROW("덤벨로우", "BACK03"),
    LAT_PULL_DOWN("렛풀다운", "BACK04"),
    T_BAR_ROW("티바로우", "BACK05");

    private String type;
    private String code;

    Back(String type) { this.type = type;}

    Back(String type, String code) {
        this.type = type;
        this.code = code;
    }
}
