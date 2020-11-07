package net.app.api.util;

import java.time.LocalDateTime;
import net.app.api.dto.ApiResponse;
import net.app.api.dto.UserDto;
import net.app.api.entity.User;
import org.springframework.beans.BeanUtils;

/**
 * Application's utility consumed by various layers of application.
 *
 * @author Anish Panthi
 */
public class AppUtil {

  /**
   * Converts given entity to dto.
   *
   * @param user entity
   * @return dto of entity
   */
  public static UserDto convertEntityToDto(User user) {
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);
    return userDto;
  }

  /**
   * Converts given dto to entity.
   *
   * @param userDto dto
   * @return entity of dto
   */
  public static User convertDtoToEntity(UserDto userDto) {
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    return user;
  }

  /**
   * Creates response to send for save, delete and put operations.
   *
   * @param message actual message to return
   * @return response object
   */
  public static ApiResponse createResponse(String message) {
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setApiMessage(message);
    apiResponse.setTimeStamp(LocalDateTime.now());
    return apiResponse;
  }
}
