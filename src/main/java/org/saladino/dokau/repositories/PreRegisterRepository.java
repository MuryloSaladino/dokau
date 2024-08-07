package org.saladino.dokau.repositories;

import org.saladino.dokau.entities.PreRegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreRegisterRepository extends CrudRepository<PreRegisterEntity, Long> {
    Optional<PreRegisterEntity> findByEmail(String email);
    void deleteByEmail(String email);
}
