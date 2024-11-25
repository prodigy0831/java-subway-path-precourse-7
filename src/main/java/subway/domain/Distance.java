package subway.domain;

import java.util.Objects;

public class Distance {
    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }
    public static Distance valueOf(String distance){
        return new Distance(Integer.parseInt(distance));
    }

    @Override
    public boolean equals(Object o){
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }
    public int getDistance(){
        return distance;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(distance);
    }

    @Override
    public String toString(){
        return String.valueOf(distance);
    }
}
