package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dmytro.Khomenko on 04.01.2020.
 */
@Data
@EqualsAndHashCode(exclude = "recipes")
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String categoryName;

  @ManyToMany(mappedBy = "categories")
  private Set<Recipe> recipes;

}
