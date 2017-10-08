package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;

/**
 * Created by Do My Duyen on 10/7/2017.
 */
public interface IngredientService {

    public IngredientCommand findCommandById(Long id);

    public Ingredient findById(Long id);

    public IngredientCommand findByRecipeIdAndId(Long recipeId, Long id);
}
