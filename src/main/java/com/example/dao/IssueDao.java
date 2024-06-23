package com.example.dao;

import com.example.pojo.bo.Issue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IssueDao {
    List<Issue> selectIssue();
}
