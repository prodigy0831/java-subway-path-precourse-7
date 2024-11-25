package subway.view;

import java.util.List;

public class OutputView {
    public void printMainOption() {
        println();
        System.out.println("메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public void printResult(int distance, int time, List<String> route) {
        println();
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.printf("[INFO] 총 거리: %skm\n", distance);
        System.out.printf("[INFO] 총 소요 시간: %s분\n", time);
        System.out.println("[INFO] ---");
        for (String stationName : route) {
            System.out.printf("[INFO] %s\n", stationName);
        }
    }

    private void println() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printServiceOption() {
        println();
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }
}
