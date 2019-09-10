package com.thoughtworks.shape.respository;


import com.thoughtworks.shape.model.CustomerOrder;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {
//    Order save(Order order);
}
