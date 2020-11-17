package com.bozkoyun.issuemanagment.service.impl;

import com.bozkoyun.issuemanagment.dto.IssueHistoryDto;
import com.bozkoyun.issuemanagment.entity.Issue;
import com.bozkoyun.issuemanagment.entity.IssueHistory;
import com.bozkoyun.issuemanagment.repository.IssueHistoryRepository;
import com.bozkoyun.issuemanagment.service.IssueHistoryService;
import com.bozkoyun.issuemanagment.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper ;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
        this.issueHistoryRepository = issueHistoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueHistoryDto save(IssueHistoryDto issueHistory) {

        IssueHistory ih=modelMapper.map(issueHistory,IssueHistory.class);
        ih=issueHistoryRepository.save(ih);
        issueHistory.setId(ih.getId());

        return issueHistory;
    }

    @Override
    public IssueHistoryDto getById(Long id) {
        IssueHistory ih=issueHistoryRepository.getOne(id);
        IssueHistoryDto dtos=modelMapper.map(ih,IssueHistoryDto.class);
        return dtos;
    }

    @Override
    public List<IssueHistoryDto> getByIssueId(Long id) {
        List<IssueHistory> ih=issueHistoryRepository.getByIssueIdOrderById(id);
        List<IssueHistoryDto> dtos= Arrays.asList(modelMapper.map(ih,IssueHistoryDto[].class));

        return dtos;
    }

    @Override
    public TPage<IssueHistoryDto> getAllPageable(Pageable pageable) {
        Page<IssueHistory> data=issueHistoryRepository.findAll(pageable);
        TPage<IssueHistoryDto> respnose = new TPage<IssueHistoryDto>();
        respnose.setStat(data,Arrays.asList(modelMapper.map(data.getContent(),IssueHistoryDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(IssueHistoryDto issueHistory) {
        issueHistoryRepository.deleteById(issueHistory.getId());
        return Boolean.TRUE;
    }

    @Override
    public void addHistory(Long id, Issue issue) {
        IssueHistory history=new IssueHistory();
        history.setIssue(issue);
        history.setAssignee(issue.getAssignee());
        history.setDate(issue.getDate());
        history.setDescription(issue.getDescription());
        history.setDetails(issue.getDetails());
        history.setIssueStatus(issue.getIssueStatus());
        issueHistoryRepository.save(history);



    }
}
