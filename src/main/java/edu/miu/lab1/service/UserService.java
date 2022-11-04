package edu.miu.lab1.service;

import edu.miu.lab1.entity.dto.PostDto;
import edu.miu.lab1.entity.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<UserDto> findAll();

    UserDto findById(long id);

    void deleteById(long id);

    void save(UserDto p);

    void update(long userId, UserDto u);

    List<UserDto> findUsersWithMoreThanOnePost();
}
