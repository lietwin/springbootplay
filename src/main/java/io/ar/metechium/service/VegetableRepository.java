package io.ar.metechium.service;

import io.ar.metechium.domain.Vegetable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VegetableRepository extends CrudRepository<Vegetable, Long> {
   List<Vegetable> findByName(String name);
}
