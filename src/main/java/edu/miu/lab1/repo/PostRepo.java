package edu.miu.lab1.repo;

import edu.miu.lab1.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> findAll();
    List<Post> findByAuthor(String author);

    List<Post> findByUserId(long userId);
}
