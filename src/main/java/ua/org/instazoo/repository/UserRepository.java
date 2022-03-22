package ua.org.instazoo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.instazoo.entity.User;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findUserByUsername(String username);

  Optional<User> findUserByEmail(String email);

  Optional<User> findUserById(Long id);
}
