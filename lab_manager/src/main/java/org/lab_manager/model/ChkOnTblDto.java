package org.lab_manager.model;

import java.util.Date;

public class ChkOnTblDto {
    private Integer id;

    private Date date;

    private String studentId;

    private String courseId;

    private Float scoreId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Float getScoreId() {
        return scoreId;
    }

    public void setScoreId(Float scoreId) {
        this.scoreId = scoreId;
    }
}