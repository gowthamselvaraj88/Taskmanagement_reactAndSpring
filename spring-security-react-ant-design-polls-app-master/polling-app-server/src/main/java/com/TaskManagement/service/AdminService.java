package com.TaskManagement.service;

import com.TaskManagement.model.BookingEntity;
import com.TaskManagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {


    @Autowired
    public BookingRepository bookingRepository;
    public List<BookingEntity> getDetails(){

        List<BookingEntity> details = new ArrayList<>();
        bookingRepository.findAll().forEach(details::add);
        return details;
    }


    public void updateStatus(String status,Long userId){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setStatus("Done");
    }

    public void  deleteUser(Long userId){
        bookingRepository.deleteById(userId);
    }
}
