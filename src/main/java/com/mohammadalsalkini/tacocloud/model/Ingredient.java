package com.mohammadalsalkini.tacocloud.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private  String id;
    private  String name;
    private  String type;

    public static enum Type {
        WARP, PROTEIN, VEGGIES, CHEESE, SAUSE
    }

}
