package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;

import java.util.Set;

/**
 * Created by Do My Duyen on 8/21/2017.
 */
public interface RecipeService {

    public Set<Recipe> getRecipes();
    public Recipe getRecipe(Long id) throws Exception;
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(Long id);
    void deleteById(Long id);
}
