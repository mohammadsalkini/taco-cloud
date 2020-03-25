package com.mohammadalsalkini.tacocloud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.mohammadalsalkini.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import com.mohammadalsalkini.tacocloud.model.Taco;
import com.mohammadalsalkini.tacocloud.model.Ingredient;
import com.mohammadalsalkini.tacocloud.model.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public String showDesignForm(Model model) {

        log.info("Start showDesignForm method ...");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        log.info("End showDesignForm method.");
        return "design";
    }

    @PostMapping
    public String processingDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
        log.info("Start processingDesign method ...");
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);
        log.info("End processingDesign method.");
        return "redirect:/orders/current";

    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        log.info("inside filterByType method ...");
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}