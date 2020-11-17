package com.bozkoyun.issuemanagment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Issue  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description",length = 4000)
    private String description ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;
    @Column(name = "details",length = 4000)
    private String details;
    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(fetch=FetchType.LAZY,optional = true)
    private User assignee;

    @JoinColumn(name="project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;

}
