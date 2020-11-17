package com.bozkoyun.issuemanagment.service;

import com.bozkoyun.issuemanagment.dto.IssueDto;
import com.bozkoyun.issuemanagment.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);
    IssueDto getById(Long id);
    TPage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete(Long issue);
    IssueDto update(Long id,IssueDto project);
}
