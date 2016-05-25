package org.lab_manager.entity;

/**
<<<<<<< HEAD
 * Created by xiaofeige on 2016/5/23.
 */
public class Experiment {
    private String Course_id;
    private String Course_name;
    private String Class_name;
    private Integer Term;
    private String Room_num;
    private String Teacher;
    private String Start_time;
    private String End_time;

    public String getCourse_id() {
        return Course_id;
    }

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_id(String SID) {
        this.Course_id = Course_id;
    }

    public void setCourse_name(String SName) {
        this.Course_name = Course_name;
    }

    public String getClass_name() {
        return Class_name;
    }

    public void setClass_name(String Class_name) {
        this.Class_name = Class_name;
    }

    public Integer getTerm() {
        return Term;
    }

    public void setTerm(Integer term) {
        this.Term = term;
    }

    public String getRoomNum() {
        return Room_num;
    }

    public void setRoomNum(String roomNum) {
        this.Room_num = roomNum;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        this.Teacher = teacher;
    }

    public String getStartTime() {
        return Start_time;
    }

    public void setStartTime(String startTime) {
        this.Start_time = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return End_time;
    }

    public void setEndTime(String endTime) {
        this.End_time = endTime;
    }
}
