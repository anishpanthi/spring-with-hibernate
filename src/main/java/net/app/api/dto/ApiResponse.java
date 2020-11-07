package net.app.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response POJO to be returned after performing DB operations, like SAVE, UPDATE and DELETE.
 *
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse implements Serializable {

  private String apiMessage;

  private LocalDateTime timeStamp;
}
