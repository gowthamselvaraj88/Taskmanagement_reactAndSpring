package com.TaskManagement.repository;

import com.TaskManagement.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Bookings, Long> {

//    @Query(value = "SELECT * FROM booking_details WHERE status = is_waiting")
//    List<Bookings> findAllActiveCustomers();
}
