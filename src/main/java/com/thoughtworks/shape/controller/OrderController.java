package com.thoughtworks.shape.controller;

import com.thoughtworks.shape.model.CustomerOrder;
import com.thoughtworks.shape.respository.OrderRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;


@Controller("/order")
@Api(value = "OrderController", description = "Operations pertaining to Orders in Online Store")
public class OrderController {

    private OrderRepository orderRepository;

    @Inject
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Get("/")
    public Iterable<CustomerOrder> list() {
        return orderRepository.findAll();
    }

    @ApiOperation(value = "Place the order", response = CustomerOrder.class)
    @Post("/create")
    public HttpResponse<CustomerOrder> saveOrder(@Body CustomerOrder customerOrder) {
        try {
            CustomerOrder createdCustomerOrder = orderRepository.save(customerOrder);
            return HttpResponse
                    .created(createdCustomerOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResponse.created(null);
    }


}
