package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/26.
 */
public class LabUse {
    private Integer ID;
    private Integer Room_id;
    private String Lab_name;
    private String Applicant;
    private String Week;
    private String Weekday;
    private String Course;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(Integer room_id) {
        Room_id = room_id;
    }

    public String getLab_name() {
        return Lab_name;
    }

    public void setLab_name(String lab_name) {
        Lab_name = lab_name;
    }

    public String getApplicant() {
        return Applicant;
    }

    public void setApplicant(String applicant) {
        Applicant = applicant;
    }

    public String getWeek() {
        return Week;
    }

    public void setWeek(String week) {
        Week = week;
    }

    public String getWeekday() {
        return Weekday;
    }

    public void setWeekday(String weekday) {
        Weekday = weekday;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
