package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmytro.Khomenko on 05.01.2020.
 */
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;

  @Override
  public Set<Recipe> getRecipes() {
    Set<Recipe> recipes = new HashSet<>();
    recipeRepository.findAll()
      .iterator()
      .forEachRemaining(recipes::add);
    return recipes;
  }

}
