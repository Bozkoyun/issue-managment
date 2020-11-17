package com.bozkoyun.issuemanagment.dto;

import com.bozkoyun.issuemanagment.entity.Issue;
import com.bozkoyun.issuemanagment.entity.IssueStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueHistoryDto {

    private Long id;
    private IssueDto issue;

    private String description;

    private Date date;

    private IssueStatus issueStatus;

    private String details;

    private UserDto assignee;

}
