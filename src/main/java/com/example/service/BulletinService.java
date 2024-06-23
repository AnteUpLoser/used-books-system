package com.example.service;

import com.example.pojo.bo.Bulletin;
import com.example.pojo.dto.BulletinDto;

import java.util.List;

public interface BulletinService {
    void addNewBulletin(BulletinDto newBull);
    void deleteBulletin(int bullId);
    List<Bulletin> showBulletins(int isDelete);
}
