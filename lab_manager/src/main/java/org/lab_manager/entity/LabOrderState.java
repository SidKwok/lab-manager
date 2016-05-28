package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/27.
 */
public class LabOrderState {
    private String Course_name;
    private String Start_time;
    private String Week_day;
    private String Day_time;
    private String State;

    //Equip数据
    private String Device_name;
    private Integer Equip_number;
    private String Order_date;
    private Integer Days;
    private Integer Order_id;

    public Integer getEquip_number() {
        return Equip_number;
    }

    public void setEquip_number(Integer equip_number) {
        Equip_number = equip_number;
    }

    public String getOrder_date() {
        return Order_date;
    }

    public void setOrder_date(String order_date) {
        Order_date = order_date;
    }

    public Integer getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Integer order_id) {
        Order_id = order_id;
    }



    public String getDevice_name() {
        return Device_name;
    }

    public void setDevice_name(String device_name) {
        Device_name = device_name;
    }

    public Integer getNumber() {
        return Equip_number;
    }

    public void setNumber(Integer number) {
        Equip_number = number;
    }

    public Integer getDays() {
        return Days;
    }

    public void setDays(Integer days) {
        Days = days;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDevice_state() {
        return Device_state;
    }

    public void setDevice_state(String device_state) {
        Device_state = device_state;
    }

    private String Date;
    private String Device_state;

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    public String getStart_time() {
        return Start_time;
    }

    public void setStart_time(String start_time) {
        Start_time = start_time;
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
}
