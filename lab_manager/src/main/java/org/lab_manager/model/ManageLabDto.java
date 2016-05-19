package org.lab_manager.model;

public class ManageLabDto {
    private Integer id;

    private Integer roomNum;

    private String comment;

    private String manageTeacher;

    private String intro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getManageTeacher() {
        return manageTeacher;
    }

    public void setManageTeacher(String manageTeacher) {
        this.manageTeacher = manageTeacher == null ? null : manageTeacher.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}