package io.zipcoder.production.worldquest.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by rsparks on 10/26/15.
 */
public interface QuestionDAO extends CrudRepository<Question, Integer> {
}
