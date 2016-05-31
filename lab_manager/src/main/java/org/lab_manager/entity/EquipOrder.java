package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/28.
 */
public class EquipOrder {
    private String Order_id;
    private String Device_name;
    private Integer Equip_number;
    private String Applicant;

    private String Start_time;
    private String End_time;
    private String Order_date;
    private String Device_state;

    public String getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(String order_id) {
        Order_id = order_id;
    }

    public String getDevice_name() {
        return Device_name;
    }

    public void setDevice_name(String device_name) {
        Device_name = device_name;
    }

    public Integer getEquip_number() {
        return Equip_number;
    }

    public void setEquip_number(Integer equip_number) {
        Equip_number = equip_number;
    }

    public String getApplicant() {
        return Applicant;
    }

    public void setApplicant(String applicant) {
        Applicant = applicant;
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

    public String getOrder_date() {
        return Order_date;
    }

    public void setOrder_date(String order_date) {
        Order_date = order_date;
    }

    public String getDevice_state() {
        return Device_state;
    }

    public void setDevice_state(String device_state) {
        Device_state = device_state;
    }
}
