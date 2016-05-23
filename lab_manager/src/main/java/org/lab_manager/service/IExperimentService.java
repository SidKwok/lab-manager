package org.lab_manager.service;

import org.lab_manager.entity.Experiment;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/23.
 */
public interface IExperimentService {
    /**
     * 按编号查询获取实验信息
     *
     */
    public Experiment getExperimentById(String eId);
}
