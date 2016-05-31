package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Role;
import org.lab_manager.entity.User;

/**
 * Created by Silence on 2016/5/28.
 */
public interface UserDao {
    public Role getRole(String roleId);

    public String getRoleId(@Param("user_id") String userId, @Param("password") String pwd);
}
