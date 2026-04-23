package com.evcharging.controller;

import com.evcharging.model.Station;
import com.evcharging.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins = "*")
public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping("/add")
    public ResponseEntity<Station> addStation(@RequestBody Station station) {
        return ResponseEntity.ok(stationService.addStation(station));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable int id) {
        return ResponseEntity.ok(stationService.getStationById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Station> updateStation(@RequestBody Station station) {
        return ResponseEntity.ok(stationService.updateStation(station));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStation(@PathVariable int id) {
        stationService.deleteStation(id);
        return ResponseEntity.ok("Station deleted successfully");
    }
}