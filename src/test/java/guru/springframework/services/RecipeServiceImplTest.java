package guru.springframework.services;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.collections.Sets;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Dmytro.Khomenko on 06.01.2020.
 */

@ExtendWith(SpringExtension.class)
class RecipeServiceImplTest {

  @Mock
  private RecipeRepository recipeRepository;

  @InjectMocks
  private RecipeServiceImpl recipeService;

  Set<Recipe> recipes;

  @BeforeEach
  void setUp() {
    Recipe recipe = new Recipe();
    recipe.setDescription("Perfect Burito");
    recipe.setPrepTime(10);
    recipe.setCookTime(0);
    recipe.setDifficulty(Difficulty.EASY);
    recipe.setDirections("Directions");
    recipe.setId(4L);

    Recipe guacamoleRecipe = new Recipe();
    guacamoleRecipe.setDescription("Perfect Guacamole");
    guacamoleRecipe.setPrepTime(10);
    guacamoleRecipe.setCookTime(0);
    guacamoleRecipe.setDifficulty(Difficulty.EASY);
    guacamoleRecipe.setDirections("Direction");
    guacamoleRecipe.setId(3L);

    recipes = Sets.newSet(recipe, guacamoleRecipe);
  }

  @Test
  void getRecipes() {
    when(recipeRepository.findAll()).thenReturn(recipes);
    Set<Recipe> tempRecipes = recipeService.getRecipes();
    Recipe firstRecipe = tempRecipes.iterator()
      .next();

    verify(recipeRepository, times(1)).findAll();
    assertEquals(3L, firstRecipe.getId());
    assertEquals("Perfect Guacamole", firstRecipe.getDescription());

  }

}