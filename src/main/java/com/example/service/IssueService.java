package com.example.service;

import com.example.pojo.vo.IssuesPageVO;

public interface IssueService {
    IssuesPageVO getIssues(int pageNum, int pageSize);
}
