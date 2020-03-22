package model;

import java.sql.Time;

public class FlghtData {
    private String deppartureTime;
    private String arrivalTime;
    private String stops;
    private String duration;
    private String price;

    public String getDeppartureTime() {
        return deppartureTime;
    }

    public void setDeppartureTime(String deppartureTime) {
        this.deppartureTime = deppartureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
