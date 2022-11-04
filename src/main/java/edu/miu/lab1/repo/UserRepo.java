package edu.miu.lab1.repo;

import edu.miu.lab1.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
  List<User> findAll();

  @Query(value = "SELECT u.id ,u.name  from users u join posts on u.id = posts.user_id group by u.id, u.name having count('*') > 1", nativeQuery = true)
  List<User> findUsersWithMoreThanOnePost();
}
