package com.thoughtworks.shape.respository;


import com.thoughtworks.shape.model.Shape;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ShapeRepository extends CrudRepository<Shape, Long> {
//    Order save(Order order);
}
