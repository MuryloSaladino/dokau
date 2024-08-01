package org.saladino.dokau.repositories;

import org.saladino.dokau.entities.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity, Long> {
}
