package edu.miu.lab1.controller;


import edu.miu.lab1.entity.dto.PostDto;
import edu.miu.lab1.entity.dto.UserDto;
import edu.miu.lab1.service.PostService;
import edu.miu.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("api/v1/users")
@RestController
public class UserController {
    private final UserService userService;
    private final PostService postService;
    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService =postService;
    }




    @GetMapping
    public List<UserDto> allUsers(@RequestParam(value = "filter", required = false) boolean filter) {
        return filter == true ? userService.findUsersWithMoreThanOnePost() : userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id, HttpServletResponse res) {
        UserDto u = userService.findById(id);
        if(u == null){
            res.setStatus(404);
            return null;
        }
        else return u;

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserDto p) {
        userService.save(p);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long userId, @RequestBody UserDto u) {
        userService.update(userId, u);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> findUserPosts(@PathVariable("id") long userId) {
        return postService.findByUserId(userId);
    }
}
