package ua.org.instazoo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Data
@Entity
public class ImageModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Lob
  @Column(columnDefinition = "LONGBLOB")
  private byte[] imageBytes;
  @JsonIgnore
  private Long userId;
  @JsonIgnore
  private Long postId;

}
