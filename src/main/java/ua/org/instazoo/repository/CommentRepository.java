package ua.org.instazoo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.instazoo.entity.Comment;
import ua.org.instazoo.entity.Post;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  List<Comment> findAllByPost(Post post);

  Comment findByIdAndUserId(Long commentId, Long userId);

}
