package com.randikalakmal.spring_modulith_sample.event;

import java.time.LocalDateTime;

public record VehicleExitEvent(String vehicleNumber, LocalDateTime entryTime, LocalDateTime exitTime) {
}
