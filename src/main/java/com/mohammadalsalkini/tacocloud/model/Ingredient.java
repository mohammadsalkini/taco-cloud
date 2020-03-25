package com.mohammadalsalkini.tacocloud.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final String type;

    public static enum Type {
        WARP, PROTEIN, VEGGIES, CHEESE, SAUSE
    }

}
