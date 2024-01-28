package com.TaskManagement.service;

import com.TaskManagement.model.BookingEntity;
import com.TaskManagement.model.Bookings;
import com.TaskManagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminViewService {


    @Autowired
        public BookingRepository bookingRepository;
    public List<BookingEntity> getDetails(){
        List<BookingEntity> details = new ArrayList<>();
        bookingRepository.findAll().forEach(details::add);
        return details;
    }

    public void updateStatus(String status,Long userId){
        Optional<BookingEntity> statusUpdate = bookingRepository.findById(userId);

        statusUpdate.ifPresent(statusCheck ->{
            statusCheck.setStatus("Done");
        });
    }

    public void  deleteUser(Long userId, Bookings booking){
        bookingRepository.deleteById(userId);
    }
}