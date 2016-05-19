package org.lab_manager.model;

public class CourseTableDto {
    private Integer courseId;

    private String courseName;

    private String class;

    private Integer term;

    private String roomNum;

    private String teacher;

    private String startTime;

    private String endTime;

    private String courseTablecol;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getClass() {
        return class;
    }

    public void setClass(String class) {
        this.class = class == null ? null : class.trim();
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum == null ? null : roomNum.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getCourseTablecol() {
        return courseTablecol;
    }

    public void setCourseTablecol(String courseTablecol) {
        this.courseTablecol = courseTablecol == null ? null : courseTablecol.trim();
    }
}