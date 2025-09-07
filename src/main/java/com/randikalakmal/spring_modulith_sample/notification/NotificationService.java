package com.randikalakmal.spring_modulith_sample.notification;

import com.randikalakmal.spring_modulith_sample.event.VehicleEnteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @EventListener(VehicleEnteredEvent.class)
    public void notificationOnVehicleEntry(VehicleEnteredEvent event) {
        // send notification to the user
        System.out.println("Notification sent to vehicle " + event.vehicleNumber() + " for entry at " + event.entryTime());
    }

}
