package com.randikalakmal.spring_modulith_sample.allocation;

import com.randikalakmal.spring_modulith_sample.event.VehicleEnteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SlotAllocationService {

    private final SlotRepository slotRepository;

    public SlotAllocationService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }



    @EventListener(VehicleEnteredEvent.class)
    public void handleVehicleEntry(VehicleEnteredEvent event) {

        // find an available slot to allocate
        Slot slot = slotRepository.findFirstByAvailableTrue().orElseThrow(() -> new RuntimeException("Slot not found"));
        // update the slot DB
        slot.setAvailable(false);
        slot.setVehicleNumber(event.vehicleNumber());
        slotRepository.save(slot);

        System.out.println("Allocated slot " + slot.getSlotCode() + " to vehicle " + event.vehicleNumber() + " at " + event.entryTime());
    }



}
