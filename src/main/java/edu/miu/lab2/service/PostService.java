package edu.miu.lab2.service;

import edu.miu.lab2.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(long id);

    void deleteById(long id);

    void save(PostDto p);

    void update(long postId, PostDto p);

    List<PostDto> findByAuthor(String author);

    List<PostDto> findByUserId(long userId);
}
