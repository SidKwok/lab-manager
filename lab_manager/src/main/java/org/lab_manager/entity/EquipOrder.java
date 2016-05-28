package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/28.
 */
public class EquipOrder {
    private String Device_name;
    private Integer Equip_number;
    private Integer Days;
    private String Applicant;

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
}
