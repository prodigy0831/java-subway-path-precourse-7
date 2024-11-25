package subway.domain;

public enum StationInfo {
    GYODAE(StationName.valueOf("교대역"),
            ConnectionStations.newInstance(
                    ConnectionStationInfo.from("강남역", "2", "3"),
                    ConnectionStationInfo.from("남부터미널역", "3", "2")

            )),
    GANGNAM(StationName.valueOf("강남역"),
            ConnectionStations.newInstance(
                    ConnectionStationInfo.from("교대역", "2", "3"),
                    ConnectionStationInfo.from("역삼역", "2", "3"),
                    ConnectionStationInfo.from("양재역", "2", "8")
            )),
    YEOKSAM(StationName.valueOf("역삼역"),
            ConnectionStations.newInstance(
                    ConnectionStationInfo.from("강남역", "2", "3")
            )),
    NAMBU_TERMINAL(StationName.valueOf("남부터미널역"),
            ConnectionStations.newInstance(
                    ConnectionStationInfo.from("교대역", "3", "2"),
                    ConnectionStationInfo.from("양재역", "6", "5")
            )),
    YANGJAE(StationName.valueOf("양재역"),
            ConnectionStations.newInstance(
                    ConnectionStationInfo.from("강남역", "2", "8"),
                    ConnectionStationInfo.from("양재시민의숲역", "10", "3"),
                    ConnectionStationInfo.from("남부터미널역", "6", "5"),
                    ConnectionStationInfo.from("매봉역", "1", "1")
            )),
    MARBONG(StationName.valueOf("매봉역"),
            ConnectionStations.newInstance(
                    ConnectionStationInfo.from("양재역", "1", "1")
            )),
    YANGJAE_FOREST(StationName.valueOf("양재시민의숲역"),
            ConnectionStations.newInstance(
                    ConnectionStationInfo.from("양재역", "10", "3")
            ));

    private final StationName name;
    private final ConnectionStations connectionStations;

    StationInfo(StationName name, ConnectionStations connectionStations) {
        this.name = name;
        this.connectionStations = connectionStations;
    }

    public StationName getName() {
        return name;
    }

    public ConnectionStations getConnectionStations() {
        return connectionStations;
    }
}
