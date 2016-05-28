package org.lab_manager.entity;

/**
 * Created by xiaofeige on 2016/5/17.
 */
public class Student {
    private String SID;
    private String SName;
    private String SClassNO;
    private Float score;
    private String password;

    public String getSID() {
        return SID;
    }

    public String getSClassNO() {
        return SClassNO;
    }

    public void setSClassNO(String SClassNO) {
        this.SClassNO = SClassNO;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
