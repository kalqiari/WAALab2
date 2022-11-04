package edu.miu.lab1.controller;

import edu.miu.lab1.entity.dto.PostDto;
import edu.miu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("api/v1/posts")
@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<PostDto> allPost(@RequestParam(value = "filter" ,required = false) String author) {
        return author == null ? postService.findAll() : postService.findByAuthor(author);
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id, HttpServletResponse res) {
        PostDto p = postService.findById(id);
        if(p == null){
            res.setStatus(404);
            return null;
        }
        else return p;

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        postService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p) {
        postService.save(p);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long postId, @RequestBody PostDto p) {
        postService.update(postId,p);
    }


}
