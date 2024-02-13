package com.almkont.foodRecipes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/search")
    public String searchRecipes(@RequestParam String ingredients, Model model) {
        Recipe[] recipes = recipeService.searchRecipesByIngredients(ingredients);
        if (recipes != null) {
            model.addAttribute("recipes", recipes != null ? recipes : new Recipe[0]);
        } else {
            // Optionally handle the case where no recipe is found
            return "redirect:/"; // Redirect back to the form or a different handling
        }
        return "result"; // This should match the name of your Thymeleaf template
    }

}
