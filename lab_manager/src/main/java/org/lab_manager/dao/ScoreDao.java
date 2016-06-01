package org.lab_manager.dao;

import org.apache.ibatis.annotations.Param;
import org.lab_manager.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Silence on 2016/6/1.
 */
@Repository
public interface ScoreDao {
    /**
     * 根据学生学号查询该学生的所有成绩
     */
    public List<Score> getScoreBySNO(String sno);
    /**
     *更新学生成绩
     */
    public boolean updateScore(@Param("sno") String sno,@Param("courseName") String courseName,@Param("score") String score);
    /**
     * 插入学生成绩
     */
    public boolean insertScore(@Param("sno") String sno,@Param("courseName") String courseName,@Param("score") String score);
    /**
     * 删除学生成绩
     */
    public boolean deleteScore(@Param("sno") String sno);
}
