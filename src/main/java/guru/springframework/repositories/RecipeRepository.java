package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Dmytro.Khomenko on 05.01.2020.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

  Optional<Recipe> findRecipeByDescription(String description);

}
