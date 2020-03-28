package com.mohammadalsalkini.tacocloud.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.mohammadalsalkini.tacocloud.model.Order;
import com.mohammadalsalkini.tacocloud.data.IngredientRepository;
import com.mohammadalsalkini.tacocloud.data.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import com.mohammadalsalkini.tacocloud.model.Taco;
import com.mohammadalsalkini.tacocloud.model.Ingredient;
import com.mohammadalsalkini.tacocloud.model.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    private TacoRepository designRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository designRepository) {
        this.ingredientRepository = ingredientRepository;
        this.designRepository = designRepository;
    }

    @ModelAttribute(name = "taco")
    public Taco taco () {
        return new Taco();
    }

    @ModelAttribute(name = "order")
    public Order order () {
        return new Order();
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
    public String processingDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
        log.info("Start processingDesign method ...");
        if (errors.hasErrors()) {
            return "design";
        }

       Taco saved = designRepository.save(design);
        order.addDesign(saved);
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