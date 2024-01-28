package com.TaskManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
public class Bookings {

    @Id
    @GeneratedValue
    @Null
    private Long userId;
    private String destination;
    private String destinationPackage;
    private Long noOfPeople;
    private Date date;
    private String hotel;
    private String isCabNeed;
    private String isGuideNeeded;

    private String status;

    public Bookings() {
    }

    public Bookings(Long userId, String destination, String destinationPackage, Long noOfPeople, Date date, String hotel, String isCabNeed, String isGuideNeeded,String status) {
        super();
        this.userId = userId;
        this.destination = destination;
        this.destinationPackage = destinationPackage;
        this.noOfPeople = noOfPeople;
        this.date = date;
        this.hotel = hotel;
        this.isCabNeed = isCabNeed;
        this.isGuideNeeded = isGuideNeeded;
        this.status = status;
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
}
