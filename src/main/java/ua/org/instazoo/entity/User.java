package ua.org.instazoo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import ua.org.instazoo.entity.enums.ERole;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Data
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable=false)
  private String name;
  @Column(unique = true, updatable = true)
  private String username;
  @Column(nullable=false)
  private String lastname;
  @Column(nullable=false)
  private String email;
  @Column(columnDefinition = "text")
  private String bio;
  @Column(length = 3000)
  private String password;

  @ElementCollection(targetClass = ERole.class)
  @CollectionTable(name = "user_role",
  joinColumns = @JoinColumn(name = "user_id"))
  private Set<ERole> roles = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
  private List<Post> posts = new ArrayList<>();

  @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
  @Column(updatable = false)
  private LocalDateTime createDate;

  @Transient
  private Collection<? extends GrantedAuthority> authorities;

  public User() {
  }

  @PrePersist
  protected void onCreate(){
    this.createDate = LocalDateTime.now();
  }

}
