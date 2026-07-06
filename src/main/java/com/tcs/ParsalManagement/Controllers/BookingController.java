package com.tcs.ParsalManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ParsalManagement.Models.Bookings;
import com.tcs.ParsalManagement.Services.BookingService;

@RestController
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    BookingService bs;

    @PostMapping("/booking")
    public Bookings createBooking(@RequestBody Bookings booking) {
        return bs.createBooking(booking);
    }

    @GetMapping("/booking/{id}")
    public Bookings getBookingById(@PathVariable String id) {
//    	System.out.println("getting1");
        return bs.getBookingById(id);
    }

    @GetMapping("/bookings/customer/{customerId}")
    public List<Bookings> getBookingsByCustomerId(@PathVariable String customerId) {
        return bs.getBookingsByCustomerId(customerId);
    }

    @PutMapping("/booking/{id}/status")
    public Bookings updateBookingStatus(@PathVariable String id, @RequestParam String status) {
        return bs.updateBookingStatus(id, status);
    }

    @GetMapping("/bookings")
    public List<Bookings> getAllBookings() {
        return bs.getAllBookings();
    }

    @GetMapping("/bookings/search")
    public List<Bookings> searchBookings(
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String serviceType,
            @RequestParam(required = false) String status) {
        return bs.searchBookings(customerId, query, location, serviceType, status);
    }
}
