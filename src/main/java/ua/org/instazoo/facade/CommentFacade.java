package ua.org.instazoo.facade;

import org.springframework.stereotype.Component;
import ua.org.instazoo.dto.CommentDTO;
import ua.org.instazoo.entity.Comment;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Component
public class CommentFacade {

  public CommentDTO commentToCommentDTO(Comment comment) {
    CommentDTO commentDTO = new CommentDTO();
    commentDTO.setId(comment.getId());
    commentDTO.setUsername(comment.getUsername());
    commentDTO.setMessage(comment.getMessage());

    return commentDTO;
  }
}
