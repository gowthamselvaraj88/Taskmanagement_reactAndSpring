//package com.example.polls.controller;
//
//
//import com.example.polls.model.PdfContent;
////import com.example.polls.service.MailSendingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/mail")
//public class MailServiceController {
//    @Autowired
//    private MailSendingService mailService;
//
//
//    @PostMapping("/sendmail")
//    public String sendMail(@RequestBody PdfContent pdf){
//
//        String subject = pdf.getDestination();
//        String body = pdf.getName();
//
//        mailService.sendMail("sasi57mano57@gmail.com",subject,body);
//
//        return "Email sent";
//    }
//}
