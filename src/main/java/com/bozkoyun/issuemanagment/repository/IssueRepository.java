package com.bozkoyun.issuemanagment.repository;

import com.bozkoyun.issuemanagment.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {


}
