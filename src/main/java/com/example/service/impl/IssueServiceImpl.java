package com.example.service.impl;

import com.example.dao.IssueDao;
import com.example.pojo.bo.Issue;
import com.example.pojo.vo.IssuesPageVO;
import com.example.service.IssueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IssueServiceImpl implements IssueService {
    @Resource
    private IssueDao issueDao;

    @Override
    public IssuesPageVO getIssues(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Issue> issues = issueDao.selectIssue();
        PageInfo<Issue> pageInfo = new PageInfo<>(issues);
        IssuesPageVO issuesPageVO = new IssuesPageVO();
        issuesPageVO.setPageNum(pageInfo.getPageNum());
        issuesPageVO.setPageSize(pageInfo.getPageSize());
        issuesPageVO.setPageIssues(pageInfo.getList());
        return issuesPageVO;
    }
}
