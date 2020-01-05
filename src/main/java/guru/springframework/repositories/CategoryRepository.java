package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Dmytro.Khomenko on 05.01.2020.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

  Optional<Category> findByCategoryName(String categoryName);

}
