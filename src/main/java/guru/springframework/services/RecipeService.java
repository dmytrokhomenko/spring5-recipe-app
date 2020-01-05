package guru.springframework.services;

import guru.springframework.domain.Recipe;

import java.util.Set;

/**
 * Created by Dmytro.Khomenko on 05.01.2020.
 */
public interface RecipeService {

  Set<Recipe> getRecipes();

}
