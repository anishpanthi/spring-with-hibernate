package net.app.api.config;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import net.app.api.event.SaveOrUpdateEventListener;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anish Panthi
 */
@Configuration
public class HibernateEntityEventListenerConfig {

  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  private final SaveOrUpdateEventListener saveOrUpdateEventListener;

  public HibernateEntityEventListenerConfig(SaveOrUpdateEventListener saveOrUpdateEventListener){
    this.saveOrUpdateEventListener = saveOrUpdateEventListener;
  }

  @PostConstruct
  protected void init(){
    SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
    EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
    registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(saveOrUpdateEventListener);
  }
}
