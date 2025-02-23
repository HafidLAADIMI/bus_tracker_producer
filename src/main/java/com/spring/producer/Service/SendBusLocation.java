package com.spring.producer.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.producer.Models.BusLocation;
import com.spring.producer.Models.LastStation;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

@Service
public class SendBusLocation {

    private final KafkaTemplate<String, LastStation> kafkaTemplate;

    public SendBusLocation(KafkaTemplate<String, LastStation> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
    }
    //generate random location for the bus
    public GeoJsonPoint generateRandomGeoJson() {
        Random random = new Random();
        double latitude = -90.0 + (random.nextDouble() * 180.0); // Random latitude between -90 and 90
        double longitude = -180.0 + (random.nextDouble() * 360.0);
        latitude = Math.round(latitude * 1000000.0) / 1000000.0;
        longitude = Math.round(longitude * 1000000.0) / 1000000.0;
        return new GeoJsonPoint(longitude, latitude);


    }
    // this function will generate randoms location for the bus location
//    public BusLocation generateRandomLocation() {
//        Random random = new Random();
//        int busId = random.nextInt(10) + 1; // Random busId between 1-10
//        double latitude = -90.0 + (random.nextDouble() * 180.0); // Random latitude between -90 and 90
//        double longitude = -180.0 + (random.nextDouble() * 360.0); // Random longitude between -180 and 180
//
//        // Format to 6 decimal places
//        latitude = Math.round(latitude * 1000000.0) / 1000000.0;
//        longitude = Math.round(longitude * 1000000.0) / 1000000.0;
//
//        // Current timestamp as string
//        Date timestamp = new Date();
//
//        return new BusLocation(busId, latitude, longitude, timestamp);
//    }

    public LastStation generateRandomLocation(){
        Random random = new Random();
        int busId = random.nextInt(10) + 1; // Random busId between 1-10
        String lastStation = "Station" + random.nextInt(10) + 1; // Random station between 1-10
        String lastStationTime = LocalTime.now().toString(); // Current time as string
        GeoJsonPoint lastStationLocation = generateRandomGeoJson(); // Random location

        return new LastStation(busId, lastStation, lastStationTime, lastStationLocation);
    }
    @Scheduled(fixedDelay = 2000)
    public void sendBusLocation() {
        LastStation lastStation = generateRandomLocation();
        try {
            // Send to Kafka
            kafkaTemplate.send("bus_location", lastStation);
            System.out.println("Sent to Kafka: " + lastStation);

        } catch (Exception e) {
            System.err.println("Error serializing location: " + e.getMessage());
        }
    }
}
