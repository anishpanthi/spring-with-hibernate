package net.app.api.event;

import lombok.extern.slf4j.Slf4j;
import net.app.api.entity.User;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

/**
 * This event listener will be called right after your save operation on database entity.
 *
 * @author Anish Panthi
 */
@Component
@Slf4j
public class SaveOrUpdateEventListener implements PostInsertEventListener {

  /**
   * Does this listener require that after transaction hooks be registered?
   *
   * @param persister The persister for the entity in question.
   * @return {@code true} if after transaction callbacks should be added.
   * @deprecated use {@link #requiresPostCommitHandling(EntityPersister)}
   */
  @Deprecated
  @Override
  public boolean requiresPostCommitHanding(EntityPersister persister) {
    return false;
  }

  @Override
  public void onPostInsert(PostInsertEvent event) {
    log.info("Inside onPostInsert method...");
    Object object = event.getEntity();
    if(object instanceof User){
      log.info("Do your stuffs here...");
    }
  }

  /**
   * Does this listener require that after transaction hooks be registered?
   *
   * @param persister The persister for the entity in question.
   * @return {@code true} if after transaction callbacks should be added.
   */
  @Override
  public boolean requiresPostCommitHandling(EntityPersister persister) {
    return false;
  }
}
