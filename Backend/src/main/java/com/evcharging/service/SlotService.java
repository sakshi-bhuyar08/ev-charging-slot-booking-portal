package com.evcharging.service;

import com.evcharging.model.Slot;
import com.evcharging.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public Slot addSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    public List<Slot> getSlotsByStation(int stationId) {
        return slotRepository.findByStationStationId(stationId);
    }

    public List<Slot> getAvailableSlots() {
        return slotRepository.findByAvailabilityStatus("available");
    }

    public Slot updateSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public void deleteSlot(int id) {
        slotRepository.deleteById(id);
    }
}