package com.randikalakmal.spring_modulith_sample.entry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parking")
public class EntryController {

    private final ParkingService parkingService;
    private final ExitService exitService;


    public EntryController(ParkingService parkingService, ExitService exitService) {
        this.parkingService = parkingService;
        this.exitService = exitService;
    }


    @PostMapping("/entry" )
    public ResponseEntity<String> entry(@RequestParam String vehicleNumber){
        parkingService.vehicleEntry(vehicleNumber);
        return ResponseEntity.ok("Vehicle entry recorded: "+vehicleNumber);
    }

    @PostMapping("/exit" )
    public ResponseEntity<String> exit(@RequestParam String vehicleNumber) {
        exitService.vehicleExit(vehicleNumber);
        return ResponseEntity.ok("Vehicle exit recorded:  "+vehicleNumber);
    }
}
