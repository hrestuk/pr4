package org.example;

import lombok.Builder;

public class Electronic extends Product
{
    @Builder
    public Electronic(String name, Double price, String description)
    {
        super(name,price,description);
    }
}
