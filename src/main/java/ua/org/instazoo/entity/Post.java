package ua.org.instazoo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.PrePersist;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class Post {

  private Long id;
  private String title;
  private String caption;
  private String location;
  private Integer likes;

  private Set<String> likedUsers = new HashSet<>();
  private User user;
  private List<Comment> comments = new ArrayList<>();
  private LocalDateTime createdDate;

  @PrePersist
  protected void onCreate(){
    this.createdDate = LocalDateTime.now();
  }


}
