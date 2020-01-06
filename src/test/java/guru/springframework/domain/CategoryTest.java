package guru.springframework.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Dmytro.Khomenko on 06.01.2020.
 */
class CategoryTest {

  private static Category category;

  @BeforeAll
  public static void setUp() {
    category = new Category();
  }

  @Test
  void getId() {
    Long idValue = 4L;
    category.setId(idValue);
    assertEquals(idValue, category.getId());
  }

  @Test
  void getCategoryName() {
    String categoryName = "Mexican";
    category.setCategoryName(categoryName);
    assertEquals(categoryName, category.getCategoryName());
  }

  @Test
  void getRecipes() {
  }

}