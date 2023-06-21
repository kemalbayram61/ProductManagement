package com.example.product_app.model.service;

import java.util.List;

public interface EntityService<E, I> {
    E findByID(I id);

    E update(E object);

    void deleteByID(I id);

    List<E> getAll();

    E save(E object);
}
