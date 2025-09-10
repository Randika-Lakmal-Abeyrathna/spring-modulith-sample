package com.randikalakmal.spring_modulith_sample.billing;

import com.randikalakmal.spring_modulith_sample.event.VehicleExitEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class BillingService {

    private final BillingRecordRepository billingRecordRepository;

    public BillingService(BillingRecordRepository billingRecordRepository) {
        this.billingRecordRepository = billingRecordRepository;
    }

    @EventListener(VehicleExitEvent.class)
    public void handleVehicleExit(VehicleExitEvent event){

        Duration duration = Duration.between(event.entryTime(), event.exitTime());
        double amount = Math.max(20,(duration.toMinutes()/60.0)*50);

        BillingRecord billingRecord = new BillingRecord(null, event.vehicleNumber(), amount, event.exitTime());

        billingRecordRepository.save(billingRecord);

        System.out.println("Billing record created for vehicle " + event.vehicleNumber() + " with amount " + amount + " for duration " + duration.toMinutes() + " minutes.");


    }


}
