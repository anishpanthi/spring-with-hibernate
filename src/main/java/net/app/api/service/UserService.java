package net.app.api.service;

import java.util.Map;
import net.app.api.dto.UserDto;
import net.app.api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface class for <code>User</code> which shows the functionality available.
 *
 * @author Anish Panthi
 */
public interface UserService extends BaseService<User, UserDto, Long> {

  /**
   * Interprets the search options and calls respective search methods.
   *
   * @param searchBy   search field
   * @param searchData values to be search
   * @param pageable   page size, number and sorting options
   * @return list of available users based on search values and search by
   * @throws RuntimeException if any exception occurs
   */
  Page<UserDto> searchInterpreter(String searchBy, Map<String, String> searchData,
      Pageable pageable) throws RuntimeException;

  /**
   * Returns list of users by firstname, lastname and email
   *
   * @param firstName first search option
   * @param lastName  second search option
   * @param email     third search option
   * @param pageable  page size, number and sorting options
   * @return list of all users that are found or empty
   */
  Page<UserDto> findAllByFirstNameOrLastNameOrEmail(String firstName, String lastName,
      String email, Pageable pageable);

  /**
   * Returns list of users by accountName, accountNumber and accountEmail
   *
   * @param accountName   first search option
   * @param accountNumber second search option
   * @param accountEmail  third search option
   * @param pageable      page size, number and sorting options
   * @return list of all users that are found or empty
   */
  Page<UserDto> findAllByAccountNameOrAccountNumberOrAccountEmail(String accountName,
      String accountNumber, String accountEmail, Pageable pageable);

}
