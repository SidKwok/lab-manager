package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/26.
 */
public class DeviceOrder {
    private Integer Order_id;
    private String Device_name;
    private Integer Number;
    private Integer Days;
    private String Applicant;
    private String Date;

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
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public Integer getDays() {
        return Days;
    }

    public void setDays(Integer days) {
        Days = days;
    }

    public String getApplicant() {
        return Applicant;
    }

    public void setApplicant(String applicant) {
        Applicant = applicant;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
