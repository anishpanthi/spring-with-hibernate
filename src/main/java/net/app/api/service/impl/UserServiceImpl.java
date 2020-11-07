package net.app.api.service.impl;

import static net.app.api.util.AppUtil.createResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import net.app.api.dto.ApiResponse;
import net.app.api.dto.UserDto;
import net.app.api.entity.User;
import net.app.api.repository.UserRepository;
import net.app.api.service.UserService;
import net.app.api.util.AppUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementation class of <code>UserService</code> which performs the actual functionalities.
 *
 * @author Anish Panthi
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Gets single entity.
   *
   * @param aLong primary key value
   * @return <code>Optional</code> of entity
   */
  @Override
  public Optional<UserDto> findOne(Long aLong) {
    return userRepository.findById(aLong).map(AppUtil::convertEntityToDto);
  }

  /**
   * Saves given entity.
   *
   * @param userDto entity to save
   * @return api response
   */
  @Override
  public ApiResponse save(UserDto userDto) {
    User user = AppUtil.convertDtoToEntity(userDto);
    user.setIsActive(Boolean.TRUE);
    userRepository.save(user);
    return createResponse("Record inserted!");
  }

  /**
   * Updates given entity.
   *
   * @param userDto entity to update
   * @return api response
   */
  @Override
  public ApiResponse update(UserDto userDto) {
    User user = AppUtil.convertDtoToEntity(userDto);
    userRepository.save(user);
    return createResponse("Record updated!");
  }

  /**
   * Finds all entities
   *
   * @return <code>List</code> of entities.
   */
  @Override
  public List<UserDto> findAll() {
    return userRepository.findAll()
        .stream()
        .map(AppUtil::convertEntityToDto)
        .collect(Collectors.toList());
  }

  /**
   * Deletes the given entity.
   *
   * @param aLong id to be deleted.
   * @return api response
   */
  @Override
  public ApiResponse delete(Long aLong) {
    Optional<UserDto> userOptional = findOne(aLong);
    userOptional.ifPresent(userDto -> userRepository.delete(AppUtil.convertDtoToEntity(userDto)));
    return createResponse("Record deleted!");
  }

  /**
   * Interprets the search options and calls respective search methods.
   *
   * @param searchBy   search field
   * @param searchData values to be search
   * @param pageable   page size, number and sorting options
   * @return list of available users based on search values and search by
   * @throws RuntimeException if any exception occurs
   */
  @Override
  public Page<UserDto> searchInterpreter(String searchBy, Map<String, String> searchData,
      Pageable pageable) throws RuntimeException {
    switch (searchBy) {
      case "user":
        return findAllByFirstNameOrLastNameOrEmail(searchData.get("firstName"),
            searchData.get("lastName"),
            searchData.get("email"), pageable);
      case "account":
        return findAllByAccountNameOrAccountNumberOrAccountEmail(
            searchData.get("accountName"),
            searchData.get("accountNumber"), searchData.get("accountEmail"), pageable);
      default:
        throw new RuntimeException("Search criteria not found. Please check your search options.");
    }
  }

  /**
   * Returns list of users by firstname, lastname and email
   *
   * @param firstName first search option
   * @param lastName  second search option
   * @param email     third search option
   * @param pageable  page size, number and sorting options
   * @return list of all users that are found or empty
   */
  @Override
  public Page<UserDto> findAllByFirstNameOrLastNameOrEmail(String firstName, String lastName,
      String email, Pageable pageable) {
    return userRepository.findAllByFirstNameOrLastNameOrEmail(firstName, lastName, email, pageable)
        .map(AppUtil::convertEntityToDto);
  }

  /**
   * Returns list of users by accountName, accountNumber and accountEmail
   *
   * @param accountName   first search option
   * @param accountNumber second search option
   * @param accountEmail  third search option
   * @param pageable      page size, number and sorting options
   * @return list of all users that are found or empty
   */
  @Override
  public Page<UserDto> findAllByAccountNameOrAccountNumberOrAccountEmail(String accountName,
      String accountNumber, String accountEmail, Pageable pageable) {
    return userRepository
        .findAllByAccountNameOrAccountNumberOrAccountEmail(accountName, accountNumber, accountEmail,
            pageable)
        .map(AppUtil::convertEntityToDto);
  }
}
