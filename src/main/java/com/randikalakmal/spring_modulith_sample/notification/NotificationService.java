package com.randikalakmal.spring_modulith_sample.notification;

import com.randikalakmal.spring_modulith_sample.event.VehicleEnteredEvent;
import com.randikalakmal.spring_modulith_sample.event.VehicleExitEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @EventListener(VehicleEnteredEvent.class)
    public void notificationOnVehicleEntry(VehicleEnteredEvent event) {
        // send notification to the user
        System.out.println("Notification sent to vehicle " + event.vehicleNumber() + " for entry at " + event.entryTime());
    }

    @EventListener(VehicleExitEvent.class)
    public void notificationOnVehicleExit(VehicleExitEvent event) {
        // send notification to the user
        System.out.println("Notification sent to vehicle " + event.vehicleNumber() + " for exit at " + event.exitTime());
    }

}
