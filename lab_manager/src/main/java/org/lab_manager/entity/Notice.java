package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/24.
 */
import java.sql.Timestamp;
public class Notice {
    private Integer Notice_id;
    private String Date;
    private String Content;
    private String Author;
    //private Timestamp Date;

    public Integer getNotice_id() {
        return Notice_id;
    }

    public void setNotice_id(Integer notice_id) {
        Notice_id = notice_id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
