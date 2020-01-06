package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Dmytro.Khomenko on 06.01.2020.
 */
@DataJpaTest
class UnitOfMeasureRepositoryTest {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @Test
  void findByUnitName() {
    Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByUnitName("Teaspoon");
    assertEquals("Teaspoon", teaspoon.get()
      .getUnitName());
  }

  @Test
  void findByUnitCup() {
    Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByUnitName("Cup");
    assertEquals("Cup", teaspoon.get()
      .getUnitName());
  }

}