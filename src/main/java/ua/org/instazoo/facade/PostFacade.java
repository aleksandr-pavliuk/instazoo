package ua.org.instazoo.facade;

import ua.org.instazoo.dto.PostDTO;
import ua.org.instazoo.entity.Post;

/**
 * @author Alex
 * @link https://intvw.me
 */
public class PostFacade {

  public PostDTO postToPostDTO(Post post) {
    PostDTO postDTO = new PostDTO();
    postDTO.setUsername(post.getUser().getUsername());
    postDTO.setId(post.getId());
    postDTO.setCaption(post.getCaption());
    postDTO.setLikes(post.getLikes());
    postDTO.setUsersLiked(post.getLikedUsers());
    postDTO.setLocation(post.getLocation());
    postDTO.setTitle(post.getTitle());

    return postDTO;
  }

}
