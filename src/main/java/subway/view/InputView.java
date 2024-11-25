package subway.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class InputView {
    public String enterSelectOption(){
        System.out.println("## 원하는 기능을 선택하세요.");
        return readLine().strip();
    }

    public String enterStartStation() {
        println();
        System.out.println("## 출발역을 입력하세요.");
        return readLine().strip();
    }

    private void println() {
        System.out.println();
    }

    public String enterEndStation() {
        println();
        System.out.println("## 도착역을 입력하세요.");
        return readLine().strip();
    }
}
