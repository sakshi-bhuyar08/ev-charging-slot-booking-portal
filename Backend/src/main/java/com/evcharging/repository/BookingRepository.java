	package com.evcharging.repository;

import com.evcharging.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserUserId(int userId);
    List<Booking> findByStationStationId(int stationId);
    List<Booking> findByStatus(String status);
}