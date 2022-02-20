package ua.org.instazoo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.instazoo.entity.ImageModel;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {

  Optional<ImageModel> findByUserId(Long userId);

  Optional<ImageModel> findByPostId(Long postId);
}
