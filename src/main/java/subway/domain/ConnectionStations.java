package subway.domain;

import java.util.Arrays;
import java.util.List;

public class ConnectionStations {
    private final List<ConnectionStationInfo> connectionStationInfos;

    private ConnectionStations(List<ConnectionStationInfo> connectionStationInfos) {
        this.connectionStationInfos = connectionStationInfos;
    }

    public static ConnectionStations newInstance(ConnectionStationInfo... connectionStationInfos){
        List<ConnectionStationInfo> connections = Arrays.stream(connectionStationInfos).toList();
        return new ConnectionStations(connections);
    }

    public List<ConnectionStationInfo> getConnectionStationInfos() {
        return connectionStationInfos.stream().toList();
    }

    public ConnectionStationInfo findByName(String name){
        return connectionStationInfos.stream()
                .filter(connectionStationInfo -> connectionStationInfo.getStationName().equals(name))
                .findAny()
                .orElse(null);
    }
}
