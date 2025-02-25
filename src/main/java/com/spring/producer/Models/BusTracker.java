package com.spring.producer.Models;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.io.Serializable;

public class BusTracker implements Serializable {
    private int busId;
    private String lastStation;
    private String lastStationTime;
    private GeoJsonPoint lastStationLocation;// this  will be the location of the last station to fetch after the nearest station for the bus


    public BusTracker(int busId, String lastStation, String lastStationTime, GeoJsonPoint lastStationLocation) {
        this.busId = busId;
        this.lastStation = lastStation;
        this.lastStationTime = lastStationTime;
        this.lastStationLocation = lastStationLocation;
    }

    ;

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

    public BusTracker() {
    }

    ;

    @Override
    public String toString() {
        return "LastStation{" +
                "busId=" + busId +
                ", lastStation='" + lastStation + '\'' +
                ", lastStationTime='" + lastStationTime + '\'' +
                ", lastStationLocation=" + lastStationLocation +
                '}';
    }
}
