package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by Dmytro.Khomenko on 05.01.2020.
 */
@Controller
@RequiredArgsConstructor
public class MainController {

  private final CategoryRepository categoryRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  @RequestMapping({"", "/", "/index"})
  public String getIndexPage() {
    Optional<Category> categoryOptional = categoryRepository.findByCategoryName("American");
    Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUnitName("Teaspoon");

    System.out.println("Category Id is " + categoryOptional.get()
      .getId());
    System.out.println("Unit Of Measure Id is " + unitOfMeasureOptional.get()
      .getId());

    return "index";
  }

}
