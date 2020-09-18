package net.app.api.repository;

import net.app.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
