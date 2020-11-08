package net.app.api.entity;

import java.time.LocalDateTime;
import java.util.UUID;
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
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.domain.Persistable;

/**
 * Entity class for table "USER".
 *
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
//@Where(clause = "is_active = 'true'")   // Uncomment this if database is H2 and comment line 33
@Where(clause = "is_active = '1'")        // Uncomment this if database is MySQL and comment line 32
//@SQLDelete(sql = "UPDATE user SET is_Active = 'false' WHERE user_id = ?", check = ResultCheckStyle.COUNT)   // Uncomment this if database is H2 and comment line 35
@SQLDelete(sql = "UPDATE user SET is_Active = '0' WHERE user_id = ?", check = ResultCheckStyle.COUNT)         // Uncomment this if database is MySQL and comment line 34
@Builder
public class User implements Persistable<UUID> {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "USER_ID")
  private UUID id;

  @Column(name = "FIRST_NM")
  private String firstName;

  @Column(name = "LAST_NM")
  private String lastName;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

  @Column(name = "ACCOUNT_NM")
  private String accountName;

  @Column(name = "ACCOUNT_EMAIL")
  private String accountEmail;

  @Column(name = "ACCOUNT_NUM")
  private String accountNumber;

  @Column(name = "CREATED_ON")
  @CreationTimestamp
  private LocalDateTime createdOn;

  @Column(name = "UPDATED_ON")
  @UpdateTimestamp
  private LocalDateTime updatedOn;

  /**
   * Returns if the {@code Persistable} is new or was persisted already.
   *
   * @return if {@literal true} the object is new.
   */
  @Override
  public boolean isNew() {
    return true;
  }
}
