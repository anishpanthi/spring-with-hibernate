package net.app.api.repository;

import net.app.api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository layer for entity <code>User</code>
 *
 * @author Anish Panthi
 */
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Performs SELECT operation on table <code>User</code>
   *
   * @param firstName first search option
   * @param lastName  second search option
   * @param email     third search option
   * @param pageable  page size, number and sorting options
   * @return list of users found by firstname, lastname and email.
   */
  Page<User> findAllByFirstNameOrLastNameOrEmail(String firstName, String lastName, String email,
      Pageable pageable);

  /**
   * Performs SELECT operation on table <code>User</code>
   *
   * @param accountName   first search option
   * @param accountNumber second search option
   * @param accountEmail  third search option
   * @param pageable      page size, number and sorting options
   * @return list of users found by accountName, accountNumber and accountEmail.
   */
  Page<User> findAllByAccountNameOrAccountNumberOrAccountEmail(String accountName,
      String accountNumber, String accountEmail, Pageable pageable);
}
