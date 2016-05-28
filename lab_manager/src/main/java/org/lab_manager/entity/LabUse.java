package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/26.
 */
public class LabUse {
    private String Room_name;
    private String Teacher;
    private String Week;
    private String Weekday;
    private String Day_time;

    public String getLab_name() {
        return Room_name;
    }

    public void setLab_name(String lab_name) {
        Room_name = lab_name;
    }

    public String getApplicant() {
        return Teacher;
    }

    public void setApplicant(String applicant) {
        Teacher = applicant;
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
        return Day_time;
    }

    public void setCourse(String course) {
        Day_time = course;
    }
}
