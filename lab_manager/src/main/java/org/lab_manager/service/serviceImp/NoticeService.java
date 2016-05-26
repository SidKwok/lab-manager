package org.lab_manager.service.serviceImp;

import org.lab_manager.entity.Notice;
import org.lab_manager.service.INoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaofeige on 2016/5/26.
 */
@Service
public class NoticeService implements INoticeService{


    @Override
    public List<Notice> queryAllNotice() {
        return null;
    }

    @Override
    public boolean addNotice(Notice notice) {
        return false;
    }

    @Override
    public boolean deleteNoticeById(String id) {
        return false;
    }

    @Override
    public boolean updateNotice(Notice notice) {
        return false;
    }
}
