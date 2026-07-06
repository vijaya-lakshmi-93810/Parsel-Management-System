package com.tcs.ParsalManagement.Services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.ParsalManagement.Models.Bookings;
import com.tcs.ParsalManagement.Repositories.BookingRepository;

@Service
@Transactional
public class BookingService {

    @Autowired
    BookingRepository br;

    public Bookings createBooking(Bookings booking) {
        booking.setStatus("Booked");
        booking.setPaymentTime(new Timestamp(System.currentTimeMillis()));
        
        double baseCost = 50.0;
        double weightCost = booking.getWeight() * 20.0;
        double speedCost = "Express".equalsIgnoreCase(booking.getDeliveryType()) ? 100.0 : 0.0;
        double packCost = !"Standard".equalsIgnoreCase(booking.getPackingPref()) ? 50.0 : 0.0;
        booking.setCost(baseCost + weightCost + speedCost + packCost);
        
        return br.save(booking);
    }

    public Bookings getBookingById(String bookingId) {
        Optional<Bookings> opt = br.findById(bookingId);
        return opt.orElse(null);
    }

    public List<Bookings> getBookingsByCustomerId(String customerId) {
        return br.findByCustomerId(customerId);
    }

    public Bookings updateBookingStatus(String bookingId, String status) {
        Optional<Bookings> opt = br.findById(bookingId);
        if (opt.isPresent()) {
            Bookings booking = opt.get();
            booking.setStatus(status);
            
            if ("Picked Up".equalsIgnoreCase(status)) {
                booking.setPickupTime(new Timestamp(System.currentTimeMillis()));
            } else if ("Delivered".equalsIgnoreCase(status)) {
                booking.setDropoffTime(new Timestamp(System.currentTimeMillis()));
            }
            
            return br.save(booking);
        }
        return null;
    }

    public List<Bookings> getAllBookings() {
        return br.findAll();
    }

    public List<Bookings> searchBookings(String customerId, String query, String location, String serviceType, String status) {
        if (query != null && query.trim().isEmpty()) query = null;
        if (location != null && (location.trim().isEmpty() || location.equalsIgnoreCase("Location"))) location = null;
        if (serviceType != null && (serviceType.trim().isEmpty() || serviceType.equalsIgnoreCase("Service Type"))) serviceType = null;
        if (status != null && (status.trim().isEmpty() || status.equalsIgnoreCase("Status"))) status = null;
        
        return br.searchBookings(customerId, query, location, serviceType, status);
    }
}
