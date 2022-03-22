package ua.org.instazoo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;
import ua.org.instazoo.entity.enums.ERole;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Data
@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String caption;
  private String location;
  private Integer likes;

  @Column
  @ElementCollection(targetClass = String.class)
  private Set<String> likedUsers = new HashSet<>();
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
  @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "post", orphanRemoval = true)
  private List<Comment> comments = new ArrayList<>();
  @Column(updatable = false)
  private LocalDateTime createdDate;

    public Post() {
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }
}
