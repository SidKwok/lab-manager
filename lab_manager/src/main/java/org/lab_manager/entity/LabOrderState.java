package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/27.
 */
public class LabOrderState {
    private Integer ID;
    private String Course_name;
    private String Teacher;
    private String Start_time;
    private String End_time;
    private String Room_id;

    private String Week_day;
    private String Day_time;

    private String State;

    private String Order_date;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getStart_time() {
        return Start_time;
    }

    public void setStart_time(String start_time) {
        Start_time = start_time;
    }

    public String getEnd_time() {
        return End_time;
    }

    public void setEnd_time(String end_time) {
        End_time = end_time;
    }

    public String getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(String room_id) {
        Room_id = room_id;
    }

    public String getWeek_day() {
        return Week_day;
    }

    public void setWeek_day(String week_day) {
        Week_day = week_day;
    }

    public String getDay_time() {
        return Day_time;
    }

    public void setDay_time(String day_time) {
        Day_time = day_time;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getOrder_date() {
        return Order_date;
    }

    public void setOrder_date(String order_date) {
        Order_date = order_date;
    }
}
