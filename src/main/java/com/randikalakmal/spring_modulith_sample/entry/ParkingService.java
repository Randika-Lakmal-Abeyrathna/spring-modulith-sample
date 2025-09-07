package com.randikalakmal.spring_modulith_sample.entry;

import com.randikalakmal.spring_modulith_sample.event.VehicleEnteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingService {

    private final ParkingEntryRepository parkingEntryRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    public ParkingService(ParkingEntryRepository parkingEntryRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.parkingEntryRepository = parkingEntryRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    // save vehicle entry details to DB

    public void vehicleEntry(String vehicleNumber) {
        ParkingEntry parkingEntry = new ParkingEntry(null, vehicleNumber, LocalDateTime.now(), null, true);
        parkingEntryRepository.save(parkingEntry);

        // publish an event to allocate a parking slot
        applicationEventPublisher.publishEvent(new VehicleEnteredEvent(vehicleNumber,parkingEntry.getEntryTime()));

    }

    // allocate a parking slot

    // send notification to the user

}
