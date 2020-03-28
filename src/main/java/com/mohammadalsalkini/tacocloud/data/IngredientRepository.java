package com.mohammadalsalkini.tacocloud.data;

import com.mohammadalsalkini.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
