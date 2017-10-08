package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.converters.IngredientToIngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Do My Duyen on 10/7/2017.
 */
@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    @Qualifier("ingredientRepository")
    private IngredientRepository repository;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientToIngredientCommand converter;

    @Override
    public IngredientCommand findCommandById(Long id) {
        return converter.convert(findById(id));
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> option = repository.findById(id);
        return option == null ? null : option.get();
    }

    @Override
    public IngredientCommand findByRecipeIdAndId(Long recipeId, Long id) {
        Recipe recipe = recipeService.findById(recipeId);

        Set<Ingredient> ingredients = recipe.getIngredients();
        Optional<IngredientCommand> optional = ingredients.stream().filter(ingredient -> ingredient.getId().equals(id))
                                    .map(ingredient -> converter.convert(ingredient))
                                    .findFirst();
        return optional.isPresent() ? optional.get() : null;
    }
}
