package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/23.
 */
public class LabInfo {
    private Integer ID;
    private Integer Room_id;
    private String Room_name;
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
        return Room_id;
    }

    public void setRoom_num(Integer room_num) {
        Room_id = room_num;
    }

    public Integer getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(Integer room_id) {
        Room_id = room_id;
    }

    public String getRoom_name() {
        return Room_name;
    }

    public void setRoom_name(String room_name) {
        Room_name = room_name;
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
