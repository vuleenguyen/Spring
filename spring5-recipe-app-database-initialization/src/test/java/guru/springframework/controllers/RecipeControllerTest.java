package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.services.CategoryService;
import guru.springframework.services.RecipeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Created by Do My Duyen on 8/22/2017.
 */
public class RecipeControllerTest {


    RecipeController controller;

    @Mock
    RecipeService recipeService;

    @Mock
    CategoryService categoryService;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    Model model;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new RecipeController(recipeService, categoryService, recipeToRecipeCommand);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

   @Test
   public void testGetRecipe() throws Exception {

       Recipe recipe = new Recipe();
       recipe.setId(1L);

       when(recipeService.getRecipe(anyLong())).thenReturn(recipe);

       mockMvc.perform(get("/recipe/1/show"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("recipe"));
   }

   @Test
   public void testGetNewRecipeForm() throws Exception {

       when(recipeToRecipeCommand.convert(any())).thenReturn(new RecipeCommand());

       mockMvc.perform(get("/recipe/new"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("recipe"));
   }

   @Test
   public void testPostNewRecipeForm() throws Exception {

        RecipeCommand command = new RecipeCommand();
        command.setId(1L);
        command.setDescription("American");
        when(recipeService.saveRecipeCommand(any())).thenReturn(command);

        mockMvc.perform(post("/recipe/")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("id", "")
            .param("description", "American")
        )
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/recipe/1/show"));
    }

    @Test
    public void testGetUpdateView() throws Exception {

        when(recipeService.findCommandById(anyLong())).thenReturn(new RecipeCommand());

        mockMvc.perform(get("/recipe/1/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));

    }

    @Test
    public void getRecipe() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.getRecipe(anyLong())).thenReturn(recipe);

        Assert.assertEquals("recipe/show", controller.getRecipe(1L, model));

        verify(recipeService, times(1)).getRecipe(anyLong());
        verify(model, times(1)).addAttribute(eq("recipe"), eq(recipe));
    }

    @Test
    public void updateRecipe() throws Exception {
    }

}