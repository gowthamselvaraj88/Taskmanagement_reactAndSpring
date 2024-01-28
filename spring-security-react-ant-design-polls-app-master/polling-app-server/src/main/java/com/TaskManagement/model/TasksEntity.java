package com.TaskManagement.model;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table
public class TasksEntity {

    @Id
    @GeneratedValue
    @Column
    private Long taskId;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String status = "pending";
    @Column
    private Date startDate;
    @Column
    private Date endDate;

    public TasksEntity() {
    }

    public TasksEntity(Long taskId, String title, String description, String status, Date startDate, Date endDate) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
