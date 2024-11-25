package subway.domain;

import java.util.Objects;

public class Time {
    private final int time;

    private Time(int time) {
        this.time = time;
    }

    public static Time valueOf(String time){
        return new Time(Integer.parseInt(time));
    }

    public int getTime(){
        return time;
    }

    @Override
    public boolean equals(Object o){
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        Time time1 = (Time) o;
        return time==time1.time;
    }
    @Override
    public int hashCode(){
        return Objects.hashCode(time);
    }
    @Override
    public String toString(){
        return String.valueOf(time);
    }
}
