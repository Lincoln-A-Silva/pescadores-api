package com.api.application.core.persistance.repository;

import com.api.application.core.domain.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
