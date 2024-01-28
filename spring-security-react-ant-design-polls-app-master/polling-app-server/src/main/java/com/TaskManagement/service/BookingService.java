package com.TaskManagement.service;

import javax.servlet.http.HttpServletResponse;

import com.TaskManagement.model.BookingEntity;
import com.TaskManagement.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    public BookingRepository bookingRepository;

    @Autowired
    public PdfGeneratorService pdfGeneratorService;

    @Autowired
    public PdfSendService pdfSendServie;

//    @Autowired
//    private MailSendingService mailService;


    public void  addUser( BookingEntity booking){
        bookingRepository.save(booking);
    }

    public ResponseEntity<byte[]> updateBooking(Long userId, BookingEntity booking, HttpServletResponse response) throws IOException {
        /*bookingRepository.findById(userId).map(newUser ->{*/

            BookingEntity newUser = new BookingEntity();
            newUser.setDate(booking.getDate());
          //  newUser.setUserName(booking.getUserName());
            newUser.setDestination(booking.getDestination());
            newUser.setDestinationPackage(booking.getDestinationPackage());
            newUser.setNoOfPeople(booking.getNoOfPeople());
            newUser.setHotel(booking.getHotel());
            newUser.setIsCabNeed(booking.getIsCabNeed());
            newUser.setIsGuideNeeded(booking.getIsGuideNeeded());
            newUser.setPanCardNumber(booking.getPanCardNumber());
            newUser.setUserId(userId);
            bookingRepository.save(newUser);
            /*return "bookingRepository.save(booking)";
        });*/

        int noOfRecords = 200;



        String userName = "New User";
        String destination = booking.getDestination();

        response.setContentType("application/pdf");
        String headerKey = "content-diposition";
        String headerValue = "attachment; filename=pdf_.pdf";
        response.setHeader(headerKey,headerValue);

        List<Integer> inputList = new ArrayList<>();

        for(int i=0;i<noOfRecords;i++){
            inputList.add(i);
        }

        System.out.println("Size :: "+inputList.size());

        File newFile = new File("D:\\"+new Date().getTime()+"_"+userName);
        if (newFile.mkdir()){
            System.out.println("created");
        }else{
            System.out.println("Not Created");
        }

        String folderPath = String.valueOf(newFile);

        System.out.println("FolderPath :: " + folderPath);

        String path = newFile + "/" + userName + ".pdf";

        String fileName = new Date().getTime()+"_" + ".pdf";

        pdfGeneratorService.submitAsyncTask(path,userName,destination, inputList);
        pdfGeneratorService.add(folderPath,userName,fileName);

        String toEmail = "sasi77mano77@gmail.com";
        String subject = "New User Registered";
        String body = "Check customer";

        pdfSendServie.senEmailWithPdf(toEmail,subject,body,path);

        byte[] readPdf = pdfGeneratorService.readPdf(path);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_PDF);

        headers.setContentDispositionFormData(userName, userName);

        return new ResponseEntity<>(readPdf,headers, HttpStatus.OK);
    }

    /*public List<BookingEntity> getUserName(){

        List<BookingEntity> details = new ArrayList<>();
        bookingRepository.findAll().forEach(details::add);
        details.stream().map(BookingEntity::getUserName).collect(Collectors.toList());
        return details;
    }*/

}
