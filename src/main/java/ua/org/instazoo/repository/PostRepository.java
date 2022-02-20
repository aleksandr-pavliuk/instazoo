package ua.org.instazoo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.instazoo.entity.Post;
import ua.org.instazoo.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findAllByUserOrderByCreatedDateDesc(User user);

  List<Post> findAllByOrderByCreatedDateDesc();

  Optional<Post> findPostByIdAndUser(Long id, User user);

}
