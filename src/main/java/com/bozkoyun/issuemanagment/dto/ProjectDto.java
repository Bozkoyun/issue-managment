package com.bozkoyun.issuemanagment.dto;

import com.bozkoyun.issuemanagment.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private Long id;
    private String projectName;
    private String projectCode;
    private UserDto manager;
    private Long managerId;

}
