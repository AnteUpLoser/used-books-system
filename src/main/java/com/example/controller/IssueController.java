package com.example.controller;

import com.example.common.R;
import com.example.pojo.vo.IssuesPageVo;
import com.example.service.IssueService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
public class IssueController {
    @Resource
    private IssueService issueService;

    @GetMapping("/get/user/issues")
    public R<IssuesPageVo> getIssues(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize){
        return R.success(issueService.getIssues(pageNum, pageSize));
    }
}
