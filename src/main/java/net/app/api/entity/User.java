package net.app.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

/**
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Where(clause = "is_active = 'true'")
@SQLDelete(sql = "UPDATE user SET is_Active = 'false' WHERE user_id = ?", check = ResultCheckStyle.COUNT)
@SQLInsert(sql = "INSERT INTO ", check = ResultCheckStyle.COUNT)
@Builder
public class User implements Serializable {

  @Id
  @GeneratedValue(generator = "User_SequenceStyleGenerator")
  @GenericGenerator(name = "User_SequenceStyleGenerator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
          @Parameter(name = "sequence_name", value = "User_Seq"),
          @Parameter(name = "optimizer", value = "hilo"),
          @Parameter(name = "initial_value", value = "1"),
          @Parameter(name = "increment_size", value = "1")})
  @Column(name = "USER_ID")
  private Long id;

  @Column(name = "FIRST_NM")
  private String firstName;

  @Column(name = "LAST_NM")
  private String lastName;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @Column(name = "CREATED_ON")
  @CreationTimestamp
  private LocalDateTime createdOn;

  @Column(name = "UPDATED_ON")
  @UpdateTimestamp
  private LocalDateTime updatedOn;
}
