package net.app.api.service;

import java.util.List;
import java.util.Optional;
import net.app.api.dto.ApiResponse;

/**
 * Base service class which has basic functionality to entities.
 *
 * @param <E> entity
 * @param <D> dto
 * @param <ID> primary key type
 *
 * @author Anish Panthi
 * @since 09/18/2020
 */
public interface BaseService<E, D, ID> {

  /**
   * Gets single entity.
   *
   * @param id primary key value
   * @return <code>Optional</code> of entity
   */
  Optional<D> findOne(ID id);

  /**
   * Saves given entity.
   *
   * @param d entity to save
   * @return api response
   */
  ApiResponse save(D d);

  /**
   * Updates given entity.
   *
   * @param d entity to update
   * @return api response
   */
  ApiResponse update(D d);

  /**
   * Finds all entities
   *
   * @return <code>List</code> of entities.
   */
  List<D> findAll();

  /**
   * Deletes the given entity.
   *
   * @param id to be deleted.
   * @return api response
   */
  ApiResponse delete(ID id);
}
