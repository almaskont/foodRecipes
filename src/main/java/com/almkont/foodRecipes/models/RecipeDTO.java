package com.almkont.foodRecipes.models;

import java.util.List;

public class RecipeDTO {
    private String title;
    private List<IngredientDTO> usedIngredients;
    private List<IngredientDTO> missedIngredients;
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngredientDTO> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<IngredientDTO> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public List<IngredientDTO> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(List<IngredientDTO> missedIngredients) {
        this.missedIngredients = missedIngredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
