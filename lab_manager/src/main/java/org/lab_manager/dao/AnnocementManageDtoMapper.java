package org.lab_manager.dao;

import org.lab_manager.model.AnnocementManageDto;

public interface AnnocementManageDtoMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(AnnocementManageDto record);

    int insertSelective(AnnocementManageDto record);

    AnnocementManageDto selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(AnnocementManageDto record);

    int updateByPrimaryKey(AnnocementManageDto record);
}