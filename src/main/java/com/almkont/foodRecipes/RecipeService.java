package com.almkont.foodRecipes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Value("${spoonacular.api.key}")
    private String apiKey;

    @Value("${spoonacular.api.base.url}")
    private String baseUrl;

    public Recipe[] searchRecipesByIngredients(String rawIngredients) {
        try {
            String ingredientsParam = Arrays.stream(rawIngredients.split(","))
                    .map(String::trim)
                    .collect(Collectors.joining(",+"));
            String encodedIngredients = URLEncoder.encode(ingredientsParam, StandardCharsets.UTF_8.toString());
            String url = baseUrl + apiKey + "&ingredients=" + encodedIngredients + "&number=2&ignorePantry=true";

            RestTemplate restTemplate = new RestTemplate();
            RecipeDTO[] response = restTemplate.getForObject(url, RecipeDTO[].class);

            // Assuming you transform RecipeDTO[] to Recipe[] here
            return transformToRecipeArray(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Recipe[] transformToRecipeArray(RecipeDTO[] dtos) {
        if (dtos == null) return new Recipe[0];

        return Arrays.stream(dtos).map(dto -> {
            Recipe recipe = new Recipe();
            recipe.setTitle(dto.getTitle());

            // Mapping used ingredients to a list of Strings for simplicity
            List<String> usedIngredients = dto.getUsedIngredients().stream()
                    .map(ingredient -> ingredient.getAmount() + " " + ingredient.getUnit() + " " + ingredient.getName())
                    .collect(Collectors.toList());
            recipe.setUsedIngredients(usedIngredients);

            // Mapping missed ingredients to a list of Strings
            List<String> missedIngredients = dto.getMissedIngredients().stream()
                    .map(ingredient -> ingredient.getAmount() + " " + ingredient.getUnit() + " " + ingredient.getName())
                    .collect(Collectors.toList());
            recipe.setMissedIngredients(missedIngredients);
            recipe.setImgURL(dto.getImgURL());

            return recipe;
        }).toArray(Recipe[]::new);
    }

}

