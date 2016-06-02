package org.lab_manager.entity;

import org.apache.ibatis.plugin.Interceptor;

/**
 * Created by Silence on 2016/5/31.
 */
public class Attendence {
    private Integer ID;
    private String date;
    private String Student_id;
    private String Course;
    private Float Score;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String student_id) {
        Student_id = student_id;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public Float getScore() {
        return Score;
    }

    public void setScore(Float score) {
        Score = score;
    }
}
