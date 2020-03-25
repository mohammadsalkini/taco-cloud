package com.mohammadalsalkini.tacocloud.repository;

import com.mohammadalsalkini.tacocloud.model.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll ();

    Ingredient findOne(String id);

    Ingredient save (Ingredient ingredient);
}
