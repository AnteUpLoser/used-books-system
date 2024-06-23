package com.example.service.impl;

import com.example.dao.BulletinDao;
import com.example.pojo.bo.Bulletin;
import com.example.pojo.dto.BulletinDto;
import com.example.service.BulletinService;
import com.example.util.TimeUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class BulletinServiceImpl implements BulletinService {
    @Resource
    private BulletinDao bulletinDao;


    @Override
    public void addNewBulletin(BulletinDto bulletinDto) {
        Bulletin newBull = new Bulletin();
        long curUnix = TimeUtil.getCurUnix();
        newBull.setTitle(bulletinDto.getTitle())
                .setContent(bulletinDto.getContent())
                .setUpdateTime(curUnix)
                .setNotifyTime(curUnix);

        bulletinDao.insertNewBull(newBull);
    }

    @Override
    public void deleteBulletin(int bullId) {
        bulletinDao.updateIsDelete(bullId, TimeUtil.getCurUnix());
    }


    @Override
    public List<Bulletin> showBulletins(int isDelete) {
        return bulletinDao.selectIsDeleteBull(isDelete);
    }
}
