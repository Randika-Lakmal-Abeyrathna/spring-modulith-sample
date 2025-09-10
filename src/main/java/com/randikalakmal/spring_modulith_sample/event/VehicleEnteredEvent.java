package com.randikalakmal.spring_modulith_sample.event;

import java.time.LocalDateTime;

public record VehicleEnteredEvent(String vehicleNumber, LocalDateTime entryTime) {
}
