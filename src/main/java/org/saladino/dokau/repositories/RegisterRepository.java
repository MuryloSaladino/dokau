package org.saladino.dokau.repositories;

import org.saladino.dokau.entities.RegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends CrudRepository<RegisterEntity, Long> {
    Optional<RegisterEntity> findByEmail(String email);
    void deleteByEmail(String email);
}
