package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Role;
import org.lab_manager.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Silence on 2016/5/28.
 */
@Repository
public interface UserDao {
    public Role getRole(String roleId);

    public String getRoleId(@Param("user_id") String userId, @Param("password") String pwd);

    /**
     * 通过id查用户
     */
    public User getUserById(String userId);
}
