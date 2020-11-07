package net.app.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for entity class <code>User</code>
 *
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {

  private UUID id;

  private String firstName;

  private String lastName;

  private String email;

  private Boolean isActive;

  private String accountName;

  private String accountEmail;

  private String accountNumber;

  private LocalDateTime createdOn;

  private LocalDateTime updatedOn;
}
