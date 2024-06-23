package com.example.dao;

import com.example.pojo.bo.Bulletin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BulletinDao {
    List<Bulletin> selectIsDeleteBull(int isDelete);
    void insertNewBull(Bulletin newBull);
    void updateIsDelete(@Param("bullId") int bullId, @Param("deleteTime") Long deleteTime);
}
