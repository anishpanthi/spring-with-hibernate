package net.app.api.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import net.app.api.dto.ApiResponse;
import net.app.api.dto.UserDto;
import net.app.api.entity.User;
import net.app.api.repository.UserRepository;
import net.app.api.service.UserService;
import net.app.api.util.AppUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
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

  private ApiResponse createResponse(String message) {
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setApiMessage(message);
    apiResponse.setTimeStamp(LocalDateTime.now());
    return apiResponse;
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
}
