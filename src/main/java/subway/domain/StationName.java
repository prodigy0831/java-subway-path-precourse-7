package subway.domain;

import java.util.Objects;

public class StationName {
    private final String stationName;

    public StationName(String stationName) {
        this.stationName = stationName;
    }
    public static StationName valueOf(String input){
        return new StationName(input);
    }

    public String getStationName(){
        return stationName;
    }
    @Override
    public boolean equals(Object o){
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        StationName that = (StationName) o;
        return Objects.equals(stationName,that.stationName);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(stationName);
    }

    @Override
    public String toString(){
        return stationName;
    }
}
