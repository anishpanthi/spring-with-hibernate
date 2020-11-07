package net.app.api.config;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import net.app.api.dto.UserDto;
import net.app.api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Executes right after deployment is completed and inserts 5 records by default.
 *
 * @author Anish Panthi
 */
@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final UserService userService;

  /**
   * Callback used to run the bean.
   *
   * @param args incoming main method arguments
   * @throws Exception on error
   */
  @Override
  public void run(String... args) throws Exception {

    UserDto userDto1 = new UserDto(null, "Anish", "Panthi", "anish@gmail.com", true, "anish",
        "anish@chase.com", "456", LocalDateTime.now(), LocalDateTime.now());

    UserDto userDto2 = new UserDto(null, "Anish", "P", "anish@gmail.com", true, "anish",
        "anish@chase.com", "456", LocalDateTime.now(), LocalDateTime.now());

    UserDto userDto3 = new UserDto(null, "Ani", "Pan", "ani@gmail.com", true, "Ani",
        "Ani@chase.com", "456", LocalDateTime.now(), LocalDateTime.now());

    UserDto userDto4 = new UserDto(null, "Anis", "Pant", "anis@gmail.com", true, "anis",
        "anis@chase.com", "101", LocalDateTime.now(), LocalDateTime.now());

    UserDto userDto5 = new UserDto(null, "Ansh", "Pat", "ansh@gmail.com", true, "anis",
        "anis@chase.com", "101", LocalDateTime.now(), LocalDateTime.now());

    userService.save(userDto1);
    userService.save(userDto2);
    userService.save(userDto3);
    userService.save(userDto4);
    userService.save(userDto5);
  }
}
