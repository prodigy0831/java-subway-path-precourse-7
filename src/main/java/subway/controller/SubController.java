package subway.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import subway.domain.SubOption;
import subway.view.InputView;
import subway.view.OutputView;

public class SubController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<SubOption, Controllable> subControllers;

    public SubController(InputView inputview, OutputView outputView) {
        this.inputView = inputview;
        this.outputView = outputView;
        this.subControllers = new EnumMap<>(SubOption.class);
        initializeService();
    }

    private void initializeService() {
        subControllers.put(SubOption.DISTANCE_ROUTE,
                new CalculateController(inputView, outputView, SubOption.DISTANCE_ROUTE));
        subControllers.put(SubOption.TIME_ROUTE, new CalculateController(inputView, outputView, SubOption.TIME_ROUTE));
        subControllers.put(SubOption.BACK, new ExitController());
    }

    @Override
    public void process() {
        SubOption option;
        do {
            outputView.printServiceOption();
            option = doLoop(() -> SubOption.from(inputView.enterSelectOption()));
            subControllers.get(option).process();
            return;

        } while (!option.isBack());
    }

    private <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
