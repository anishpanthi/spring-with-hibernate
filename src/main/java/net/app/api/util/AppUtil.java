package net.app.api.util;

import net.app.api.dto.UserDto;
import net.app.api.entity.User;
import org.springframework.beans.BeanUtils;

/**
 * @author Anish Panthi
 */
public class AppUtil {

  public static UserDto convertEntityToDto(User user) {
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);
    return userDto;
  }

  public static User convertDtoToEntity(UserDto userDto) {
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    return user;
  }
}
