package com.almkont.foodRecipes;

import java.util.List;

public class RecipeDTO {
    private String title;
    private List<IngredientDTO> usedIngredients;
    private List<IngredientDTO> missedIngredients;
    private String imgURL;

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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
