package com.spring.producer.Models;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
public class LastStation {
    private int busId;
    private String lastStation;
    private String lastStationTime;
    private GeoJsonPoint lastStationLocation;

    public LastStation(int busId, String lastStation, String lastStationTime, GeoJsonPoint lastStationLocation) {
        this.busId = busId;
        this.lastStation = lastStation;
        this.lastStationTime = lastStationTime;
        this.lastStationLocation = lastStationLocation;
    };

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    public String getLastStationTime() {
        return lastStationTime;
    }

    public void setLastStationTime(String lastStationTime) {
        this.lastStationTime = lastStationTime;
    }

    public GeoJsonPoint getLastStationLocation() {
        return lastStationLocation;
    }

    public void setLastStationLocation(GeoJsonPoint lastStationLocation) {
        this.lastStationLocation = lastStationLocation;
    }
    public LastStation() {};
}
