package org.lab_manager.service;

import org.lab_manager.entity.Role;
import org.lab_manager.entity.Student;
import org.lab_manager.entity.Teacher;
import org.lab_manager.entity.User;

/**
 * Created by xiaofeige on 2016/5/24.
 */
public interface ILoginService {
    /**
     * 用户登陆，返回用户的角色
     * 这里的参数其实是user的id
     */
    public Role login(String username,String password);


    /**
     * 用户登录退出
     * 这里的参数其实是user的id
     */
    public boolean logout(String username);
}
