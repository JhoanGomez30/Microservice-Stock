package com.ecommerce.stock.domain.models;

public class Category {

    private final Long id;
    private final String name;
    private final String description;

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
