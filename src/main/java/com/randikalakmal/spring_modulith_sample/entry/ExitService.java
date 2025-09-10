package com.randikalakmal.spring_modulith_sample.entry;

import com.randikalakmal.spring_modulith_sample.event.VehicleEnteredEvent;
import com.randikalakmal.spring_modulith_sample.event.VehicleExitEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ExitService {

    private final ParkingEntryRepository parkingEntryRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    public ExitService(ParkingEntryRepository parkingEntryRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.parkingEntryRepository = parkingEntryRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    // save vehicle entry details to DB

    public void vehicleExit(String vehicleNumber) {

        // get vehicle entry details from DB
        ParkingEntry entry = parkingEntryRepository.findByVehicleNumberAndActiveTrue(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("vehicle number not found"));

        // update exit time and save to DB
        entry.setExitTime(LocalDateTime.now());
        entry.setActive(false);
        parkingEntryRepository.save(entry);

        // publish vehicle exit event
        applicationEventPublisher.publishEvent(new VehicleExitEvent(vehicleNumber,entry.getEntryTime(),entry.getExitTime()));

    }


}
