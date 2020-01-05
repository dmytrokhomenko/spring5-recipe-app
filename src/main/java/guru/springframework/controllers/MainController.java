package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dmytro.Khomenko on 05.01.2020.
 */
@Controller
@RequiredArgsConstructor
public class MainController {

  private final RecipeService recipeService;

  @RequestMapping({"", "/", "/index"})
  public String getIndexPage(Model model) {
    model.addAttribute("recipes", recipeService.getRecipes());

    return "index";
  }

}
