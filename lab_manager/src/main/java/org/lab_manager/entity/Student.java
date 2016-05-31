package org.lab_manager.entity;

/**
 * Created by xiaofeige on 2016/5/17.
 */
public class Student {
    private String SID;
    private String SName;
    private String SClassNO;
    private Float score;
    private String Major;

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getSClassNO() {
        return SClassNO;
    }

    public void setSClassNO(String SClassNO) {
        this.SClassNO = SClassNO;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
