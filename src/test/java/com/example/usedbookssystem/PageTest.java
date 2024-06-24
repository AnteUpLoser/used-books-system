package com.example.usedbookssystem;

import com.example.dao.BookDao;
import com.example.dao.BulletinDao;
import com.example.dao.IssueDao;
import com.example.pojo.bo.Book;
import com.example.pojo.bo.Bulletin;
import com.example.util.TimeUtil;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PageTest {
    @Autowired
    private IssueDao issueDao;
    @Autowired
    private BulletinDao bulletinDao;
    @Autowired
    private BookDao bookDao;


    @Test
    public void test01(){
        PageHelper.startPage(1,10);
        List<Book> list = bookDao.selectBooks();
        System.out.println(list);
    }

    @Test
    public void test02(){
        Bulletin bulletin = new Bulletin();
        bulletin.setTitle("1");
        bulletin.setContent("1");
        bulletin.setNotifyTime(TimeUtil.getCurUnix());
        bulletin.setUpdateTime(TimeUtil.getCurUnix());
        System.out.println(bulletinDao.selectIsDeleteBull(0));
        System.out.println();
        System.out.println();
        System.out.println();
        bulletinDao.insertNewBull(bulletin);
    }

}
