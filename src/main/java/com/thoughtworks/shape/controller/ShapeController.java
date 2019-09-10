package com.thoughtworks.shape.controller;

import com.thoughtworks.shape.model.Shape;
import com.thoughtworks.shape.respository.ShapeRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;

@Controller("/shape")
public class ShapeController {

    @Inject
    private ShapeRepository shapeRepository;

    @Get("/")
    public Iterable<Shape> list() {
        return shapeRepository.findAll();
    }


    @Post("/create")
    public HttpResponse<Shape> create(@Body Shape shape) {
        try {
            Shape createdOrder = shapeRepository.save(shape);
            return HttpResponse
                    .created(createdOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResponse.created(null);
    }
}
