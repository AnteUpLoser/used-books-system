package com.example.controller;

import com.example.common.R;
import com.example.pojo.bo.Bulletin;
import com.example.pojo.dto.BulletinDto;
import com.example.service.BulletinService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BulletinController {
    @Autowired
    private BulletinService bulletinService;

    //获取公告通知
    @GetMapping("/get/cur/bulletins/{isDelete}")
    public R<List<Bulletin>> getCurBulletin(@PathVariable int isDelete){
        return R.success(bulletinService.showBulletins(isDelete));
    }


    //新建公告
    @PostMapping("/add/new/bulletin")
    public R<String> addNewBulletin(@RequestBody BulletinDto bulletinDto) {
        bulletinService.addNewBulletin(bulletinDto);
        return R.success("新建公告成功");
    }

    //删除公告
    @PostMapping("/delete/bulletin")
    public R<String> deleteBulletinById(@RequestParam int id){
        bulletinService.deleteBulletin(id);
        return R.success("删除成功");
    }

}
