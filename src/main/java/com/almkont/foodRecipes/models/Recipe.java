package com.almkont.foodRecipes.models;

import java.util.List;

public class Recipe {
    private String title;
    private List<String> usedIngredients;
    private List<String> missedIngredients;
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<String> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public List<String> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(List<String> missedIngredients) {
        this.missedIngredients = missedIngredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
