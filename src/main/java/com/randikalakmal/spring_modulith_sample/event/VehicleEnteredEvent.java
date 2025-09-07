package com.randikalakmal.spring_modulith_sample.event;

import com.randikalakmal.spring_modulith_sample.entry.ParkingEntryRepository;

import java.time.LocalDateTime;

public record VehicleEnteredEvent(String vehicleNumber, LocalDateTime entryTime) {
}
