package com.bozkoyun.issuemanagment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "uname",length = 100,unique = true)
    private String username;
    @Column(name="pwd",length = 100)
    private String passWord;
    @Column(name = "name_surname",length = 100)
    private String nameSurname;
    @Column(name = "email",length = 250)
    private String Email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issue;




}
