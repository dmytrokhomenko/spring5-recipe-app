package guru.springframework.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Dmytro.Khomenko on 04.01.2020.
 */
@Getter
@Setter
@Entity
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private BigDecimal amount;

  @OneToOne(fetch = FetchType.EAGER)//eager is default
  private UnitOfMeasure uom;

  @ManyToOne
  private Recipe recipe;

}
