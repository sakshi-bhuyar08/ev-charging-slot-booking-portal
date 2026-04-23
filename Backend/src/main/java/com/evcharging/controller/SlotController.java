package com.evcharging.controller;

import com.evcharging.model.Slot;
import com.evcharging.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/slots")
@CrossOrigin(origins = "*")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping("/add")
    public ResponseEntity<Slot> addSlot(@RequestBody Slot slot) {
        return ResponseEntity.ok(slotService.addSlot(slot));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Slot>> getAllSlots() {
        return ResponseEntity.ok(slotService.getAllSlots());
    }

    @GetMapping("/station/{stationId}")
    public ResponseEntity<List<Slot>> getSlotsByStation(@PathVariable int stationId) {
        return ResponseEntity.ok(slotService.getSlotsByStation(stationId));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Slot>> getAvailableSlots() {
        return ResponseEntity.ok(slotService.getAvailableSlots());
    }

    @PutMapping("/update")
    public ResponseEntity<Slot> updateSlot(@RequestBody Slot slot) {
        return ResponseEntity.ok(slotService.updateSlot(slot));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSlot(@PathVariable int id) {
        slotService.deleteSlot(id);
        return ResponseEntity.ok("Slot deleted successfully");
    }
}