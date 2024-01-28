package com.TaskManagement.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_details")
public class BookingEntity {


    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long userId;
    //    private String userName;
//    private String userPassword;
    @Column
    private Integer mobileNumber;
    @Column
    private Integer panCardNumber;
    //   private String email;
    @Column
    private String city;
    @Column
    private String destination;
    @Column
    private String destinationPackage;
    @Column
    private Long noOfPeople;
    @Column
    private Date date;
    @Column
    private String hotel;
    @Column
    private String isCabNeed;
    @Column
    private String isGuideNeeded;

    @Column
    private String status = "In_waiting";


    public BookingEntity() {
    }

    public BookingEntity(Long id, String destination, String destinationPackage, Long noOfPeople, Date date, String hotel, String isCabNeed, String isGuideNeeded, String status, String userName, String userPassword, String email, Integer mobileNumber, Integer panCardNumber) {
        super();
        this.id = id;
        this.destination = destination;
        this.destinationPackage = destinationPackage;
        this.noOfPeople = noOfPeople;
        this.date = date;
        this.hotel = hotel;
        this.isCabNeed = isCabNeed;
        this.isGuideNeeded = isGuideNeeded;
        this.status = status;
       /* this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;*/
        this.mobileNumber = mobileNumber;
        this.panCardNumber = panCardNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationPackage() {
        return destinationPackage;
    }

    public void setDestinationPackage(String destinationPackage) {
        this.destinationPackage = destinationPackage;
    }

    public Long getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Long noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getIsCabNeed() {
        return isCabNeed;
    }

    public void setIsCabNeed(String isCabNeed) {
        this.isCabNeed = isCabNeed;
    }

    public String getIsGuideNeeded() {
        return isGuideNeeded;
    }

    public void setIsGuideNeeded(String isGuideNeeded) {
        this.isGuideNeeded = isGuideNeeded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
/*

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
*/

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(Integer panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
