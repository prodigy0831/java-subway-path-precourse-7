package subway.domain;

import java.util.Arrays;

public enum SubOption {

    DISTANCE_ROUTE("1"),
    TIME_ROUTE("2"),
    BACK("B");

    private final String option;

    SubOption(String option) {
        this.option = option;
    }

    public boolean isBack() {
        return this == BACK;
    }

    public static SubOption from(String input) {
        return Arrays.stream(SubOption.values())
                .filter(option -> option.getOption().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }


    private Object getOption() {
        return option;
    }
}