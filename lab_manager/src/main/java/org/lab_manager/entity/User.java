package org.lab_manager.entity;

/**
 * Created by Silence on 2016/5/28.
 */
public class User {
    private String User_id;
    private String User_name;
    private String Password;
    private String Role_id;

    public String getUser_id() {
        return User_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public String getPassword() {
        return Password;
    }

    public String getRole_id() {
        return Role_id;
    }

    public void setUser_id(String user_id) {
        User_id = user_id;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRole_id(String role_id) {
        Role_id = role_id;
    }
}
