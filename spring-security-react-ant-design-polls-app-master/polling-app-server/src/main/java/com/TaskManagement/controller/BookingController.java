package com.TaskManagement.controller;


import javax.servlet.http.HttpServletResponse;

import com.TaskManagement.model.BookingEntity;
import com.TaskManagement.security.JwtTokenProvider;
import com.TaskManagement.service.BookingService;
import com.TaskManagement.service.PdfSendService;
import com.TaskManagement.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @Autowired
    public PdfSendService pdfSendServie;

    @Autowired
    public SyncService syncService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/newcustomer")
    public void addUser(@RequestBody BookingEntity booking){
        bookingService.addUser(booking);
    }
    @RequestMapping(method= RequestMethod.PUT, value="/users")
    public void addBookings(@RequestHeader String authToken, @RequestBody BookingEntity booking, HttpServletResponse response) throws IOException {
        System.out.println("authToken "+authToken);
        Long userId = jwtTokenProvider.getUserIdFromJWT(authToken);
        System.out.println("userId ="+userId);
        bookingService.updateBooking(userId, booking,response);


    }
}
