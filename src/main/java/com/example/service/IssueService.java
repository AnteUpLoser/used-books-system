package com.example.service;

import com.example.pojo.vo.IssuesPageVo;

public interface IssueService {
    IssuesPageVo getIssues(int pageNum, int pageSize);
}
