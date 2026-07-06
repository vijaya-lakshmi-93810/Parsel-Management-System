package com.tcs.ParsalManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ParsalManagement.Models.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, String> {
    List<Bookings> findByCustomerId(String customerId);

    @org.springframework.data.jpa.repository.Query("SELECT b FROM Bookings b WHERE " +
        "(:customerId IS NULL OR b.customerId = :customerId) AND " +
        "(:searchQuery IS NULL OR b.bookingId LIKE %:searchQuery% OR b.customerName LIKE %:searchQuery% OR b.recName LIKE %:searchQuery%) AND " +
        "(:location IS NULL OR b.recAddress LIKE %:location%) AND " +
        "(:serviceType IS NULL OR b.deliveryType = :serviceType) AND " +
        "(:status IS NULL OR b.status = :status)")
    List<Bookings> searchBookings(
        @org.springframework.data.repository.query.Param("customerId") String customerId,
        @org.springframework.data.repository.query.Param("searchQuery") String searchQuery,
        @org.springframework.data.repository.query.Param("location") String location,
        @org.springframework.data.repository.query.Param("serviceType") String serviceType,
        @org.springframework.data.repository.query.Param("status") String status
    );
}
