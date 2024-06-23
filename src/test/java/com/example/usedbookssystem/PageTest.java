package com.example.usedbookssystem;

import com.example.dao.IssueDao;
import com.example.pojo.bo.Issue;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PageTest {
    @Autowired
    private IssueDao issueDao;

    @Test
    public void test01(){
        PageHelper.startPage(1,10);
        List<Issue> list = issueDao.selectIssue();
        System.out.println(list);
    }

    @Test
    public static void test02(String... args){

    }

}
