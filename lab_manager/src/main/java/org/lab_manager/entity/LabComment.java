package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/24.
 */
public class LabComment {
    private Integer ID;
    private Integer lab_id;
    private String comment;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getLab_id() {
        return lab_id;
    }

    public void setLab_id(Integer lab_id) {
        this.lab_id = lab_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
