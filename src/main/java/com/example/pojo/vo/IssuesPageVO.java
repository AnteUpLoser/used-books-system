package com.example.pojo.vo;

import com.example.pojo.bo.Issue;
import lombok.Data;

import java.util.List;

@Data
public class IssuesPageVO {
    private int pageNum;
    private int pageSize;
    private List<Issue> pageIssues;
}
