package com.evcharging.service;

import com.evcharging.model.Station;
import com.evcharging.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public Station addStation(Station station) {
        return stationRepository.save(station);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Station getStationById(int id) {
        return stationRepository.findById(id).orElse(null);
    }

    public Station updateStation(Station station) {
        return stationRepository.save(station);
    }

    public void deleteStation(int id) {
        stationRepository.deleteById(id);
    }
}