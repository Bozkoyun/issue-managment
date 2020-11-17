package com.bozkoyun.issuemanagment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project  extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_name",length = 250)
    private String projectName;
    @Column(name = "project_code",length = 200)
    private String projectCode;

    @JoinColumn(name="manager_user_id")
    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    private User manager;


}
