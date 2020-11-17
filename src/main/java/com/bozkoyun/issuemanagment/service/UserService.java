package com.bozkoyun.issuemanagment.service;

import com.bozkoyun.issuemanagment.dto.UserDto;
import com.bozkoyun.issuemanagment.util.TPage;
import org.springframework.data.domain.Pageable;


public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);
    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);



}
