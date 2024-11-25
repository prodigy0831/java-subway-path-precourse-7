package subway.domain;

public class Station {
    private StationName name;
    private final ConnectionStations connectionStations;

    public Station(StationName name,ConnectionStations connectionStations) {

        this.name = name;
        this.connectionStations = connectionStations;
    }

    public static Station from(StationName name, ConnectionStations connectionStations){
        return new Station(name,connectionStations);
    }

    public String getName() {
        return name.getStationName();
    }

    public ConnectionStations getConnectionStations(){
        return connectionStations;
    }
}
