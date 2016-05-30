package org.lab_manager.service.serviceImp;

import org.lab_manager.dao.NoticeDao;
import org.lab_manager.entity.Notice;
import org.lab_manager.service.INoticeService;
import org.lab_manager.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaofeige on 2016/5/26.
 */
@Service
public class NoticeService implements INoticeService{
    @Resource
    private NoticeDao noticeDao;

    @Override
    public List<Notice> queryAllNotice() {

        return noticeDao.getAllNotice();
    }

    @Override
    public boolean addNotice(String author,String content) {
        Notice notice=new Notice();
        notice.setAuthor(author);
        notice.setContent(content);
//        String curDate=DateTimeUtil.formatTime(DateTimeUtil.currentTimestamp(),DateTimeUtil.DATETIME_FORMATTER);
        String curDate=DateTimeUtil.dateTimeFrom(DateTimeUtil.currentTimestamp());
        notice.setDate(curDate);
        try{
            noticeDao.addNotice(notice.getDate(),notice.getContent(),notice.getAuthor());
        }catch (Exception e){
            return false;
        }
        return true;
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
