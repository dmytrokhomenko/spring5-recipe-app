package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.collections.Sets;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Dmytro.Khomenko on 06.01.2020.
 */
class MainControllerTest {

  @Mock
  RecipeService recipeService;

  @Mock
  Model model;

  MainController mainController;

  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    mainController = new MainController(recipeService);
  }

  @Test
  void getIndexPage() throws Exception {
    //given
    Recipe recipe = new Recipe();
    recipe.setId(3L);
    Recipe recipeTwo = new Recipe();
    recipe.setId(4L);
    Set<Recipe> recipes = Sets.newSet(recipe, recipeTwo);
    when(recipeService.getRecipes()).thenReturn(recipes);
    ArgumentCaptor<Set<Recipe>> setArgumentCaptor = ArgumentCaptor.forClass(Set.class);

    //when
    String viewName = mainController.getIndexPage(model);

    //then
    assertEquals("index", viewName);
    verify(recipeService, times(1)).getRecipes();
    verify(model, times(1)).addAttribute(eq("recipes"), setArgumentCaptor.capture());
    Set<Recipe> setInController = setArgumentCaptor.getValue();
    assertEquals(2, setInController.size());
  }

  @Test
  public void testMocKMvc() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(mainController)
      .build();
    mockMvc.perform(get(""))
      .andExpect(status().isOk())
      .andExpect(view().name("index"));
  }

}