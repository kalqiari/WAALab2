package edu.miu.lab2.service;

import edu.miu.lab2.entity.Post;
import edu.miu.lab2.entity.dto.PostDto;
import edu.miu.lab2.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<PostDto> findAll() {
        var posts = postRepo.findAll();
        return posts.stream().map( e-> modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto findById(long id) {
        var post = postRepo.findById(id).orElse(null);
        return post == null ? null :  modelMapper.map(post, PostDto.class);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void update(long postId, PostDto p) {
        p.setId(postId);
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto> findByAuthor(String author) {
        return postRepo.findByAuthor(author).stream().map( e-> modelMapper.map(e, PostDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<PostDto> findByUserId(long userId) {
        return postRepo.findByUserId(userId).stream().map( e-> modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
    }
}
