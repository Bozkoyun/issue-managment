package com.bozkoyun.issuemanagment.service;

import com.bozkoyun.issuemanagment.dto.IssueHistoryDto;
import com.bozkoyun.issuemanagment.entity.Issue;
import com.bozkoyun.issuemanagment.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IssueHistoryService {


    IssueHistoryDto save(IssueHistoryDto issueHistory);

    IssueHistoryDto getById(Long id);

    List<IssueHistoryDto> getByIssueId(Long id);

    TPage<IssueHistoryDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistoryDto issueHistory);

    void addHistory(Long id, Issue issue);


}
