package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.services.CategoryService;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Do My Duyen on 8/22/2017.
 */
@Controller
@Slf4j
@RequestMapping("recipe")
public class RecipeController {

    private RecipeService recipeService;

    private CategoryService categoryService;

    private RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeController(RecipeService recipeService, CategoryService categoryService
                            ,RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @RequestMapping("/{id}/show")
    public String getRecipe(@PathVariable("id") Long id, Model model) {
        try {
            Recipe recipe = recipeService.getRecipe(id);
            model.addAttribute("recipe", recipe);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return "recipe/show";
    }

    @RequestMapping("/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }

    @RequestMapping("/new")
    public String newRecipe(Model model) {
        Recipe recipe = new Recipe();
        recipe.setCategories(categoryService.getCategories());
        model.addAttribute("recipe", recipeToRecipeCommand.convert(recipe));
        return "recipe/recipeform";
    }

    @PostMapping("/")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand commandReturned = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + commandReturned.getId() + "/show";
    }

    @GetMapping("/{id}/delete")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);
        return "redirect:/";
    }
}
