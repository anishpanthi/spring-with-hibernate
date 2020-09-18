package net.app.api.controller;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import net.app.api.dto.ApiResponse;
import net.app.api.dto.UserDto;
import net.app.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@Slf4j
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * Endpoint to return all users.
   *
   * @return <code>List</code> of users
   */
  @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<UserDto>> getAllUser() {
    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
  }

  /**
   * Endpoint to save given user.
   *
   * @param userDto actual user to store
   * @return api response
   */
  @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse> saveUser(@RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.save(userDto), HttpStatus.OK);
  }

  /**
   * Endpoint to update given user.
   *
   * @param userDto actual user to update
   * @return api response
   */
  @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.update(userDto), HttpStatus.OK);
  }

  /**
   * Endpoint to return single user by id.
   *
   * @param id to search
   * @return <code>Optional</code> of user.
   */
  @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<UserDto>> findOneById(@PathVariable Long id) {
    return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
  }

  /**
   * Endpoint to delete given user
   *
   * @param id actual id of user to delete
   * @return api response
   */
  @DeleteMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
    return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
  }
}
