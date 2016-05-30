package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.User;

/**
 * Created by Silence on 2016/5/28.
 */
public interface UserDao {
    public User login(@Param("user_name") String user_name, @Param("pass_word") String pass_word);
}
