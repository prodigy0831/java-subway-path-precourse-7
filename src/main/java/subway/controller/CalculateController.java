package subway.controller;

import static subway.domain.SubOption.DISTANCE_ROUTE;

import java.util.List;
import java.util.function.Supplier;
import subway.domain.ConnectionStationInfo;
import subway.domain.ConnectionStations;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubOption;
import subway.domain.strategy.DistanceStrategy;
import subway.domain.strategy.TimeStrategy;
import subway.view.InputView;
import subway.view.OutputView;

public class CalculateController implements Controllable {
    private final InputView inputView;
    private final OutputView outputView;
    private final SubOption subOption;

    public CalculateController(InputView inputView, OutputView outputView, SubOption subOption) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.subOption = subOption;
    }

    @Override
    public void process() {
        Station startStation = doLoop(this::receiveStartStation);
        Station endStation = doLoop(this::receiveEndStation);
        if (startStation.equals(endStation)) {
            outputView.printErrorMessage("[ERROR] 출발역과 도착역이 동일합니다.");
            return;
        }
        List<String> route = routeCalculate(startStation, endStation);

        if (route == null) {
            outputView.printErrorMessage("[ERROR] 연결된 경로가 존재하지 않습니다.");
            return;
        }
        calculateResult(route);

    }

    private void calculateResult(List<String> route) {
        int totalDistance = 0;
        int totalTime = 0;
        for(int i=0;i<route.size()-1;i++){
            Station station = StationRepository.findByName(route.get(i));
            ConnectionStations connectionStations = station.getConnectionStations();
            ConnectionStationInfo connectionStationInfo = connectionStations.findByName(route.get(i+1));
            totalDistance+=connectionStationInfo.getDistance();
            totalTime+=connectionStationInfo.getTime();
        }
        outputView.printResult(totalDistance, totalTime,route);
    }

    private List<String> routeCalculate(Station startStation, Station endStation) {
        if (subOption.equals(DISTANCE_ROUTE)) {
            return DistanceStrategy.calculateShortestPath(startStation, endStation);
        }
        return TimeStrategy.calculateShortestPath(startStation, endStation);
    }

    private Station receiveEndStation() {
        String stationName = inputView.enterEndStation();
        return StationRepository.findByName(stationName);
    }

    private Station receiveStartStation() {
        String stationName = inputView.enterStartStation();
        return StationRepository.findByName(stationName);
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
