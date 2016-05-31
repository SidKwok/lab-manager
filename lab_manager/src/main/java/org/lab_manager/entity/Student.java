package org.lab_manager.entity;

/**
 * Created by xiaofeige on 2016/5/17.
 */
public class Student {
    private String SID;
    private String SName;
    private String SClassNO;
    private String Major;

    public String getSID() {
        return SID;
    }

    public String getSClassNO() {
        return SClassNO;
    }

    public void setSClassNO(String SClassNO) {
        this.SClassNO = SClassNO;
    }

    public String getSName() {
        return SName;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }
}
