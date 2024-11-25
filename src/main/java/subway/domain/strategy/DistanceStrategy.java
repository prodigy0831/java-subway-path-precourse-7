package subway.domain.strategy;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.ConnectionStationInfo;
import subway.domain.ConnectionStations;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DistanceStrategy {
    public static List<String> calculateShortestPath(Station startStation,Station endStation){
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        List<Station> stations = StationRepository.stations();

        stations.forEach(station->graph.addVertex(station.getName()));

        stations.forEach(station->{
            ConnectionStations connectionStations = station.getConnectionStations();

            for(ConnectionStationInfo connectionStation : connectionStations.getConnectionStationInfos()){
                graph.setEdgeWeight(graph.addEdge(station.getName(),connectionStation.getStationName()),connectionStation.getDistance());
            }
        });

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

        try{
            return dijkstraShortestPath.getPath(startStation.getName(),endStation.getName()).getVertexList();
        }catch(NullPointerException e ){
            return null;
        }

    }

}
