package com.hussein.java_project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hussein.java_project.models.Card;

public interface CardRepo extends CrudRepository<Card, Long> {

}
