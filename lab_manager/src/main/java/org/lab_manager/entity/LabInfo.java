package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/23.
 */
public class LabInfo {
    private Integer ID;
    private Integer Room_num;
    private String Comment;
    private String Manage_teacher;
    private String Intro;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getRoom_num() {
        return Room_num;
    }

    public void setRoom_num(Integer room_num) {
        Room_num = room_num;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getManage_teacher() {
        return Manage_teacher;
    }

    public void setManage_teacher(String manage_teacher) {
        Manage_teacher = manage_teacher;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }
}