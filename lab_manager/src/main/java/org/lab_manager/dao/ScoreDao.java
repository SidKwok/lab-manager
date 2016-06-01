package org.lab_manager.dao;

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
}
