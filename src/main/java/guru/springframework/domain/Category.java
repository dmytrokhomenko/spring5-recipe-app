package guru.springframework.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dmytro.Khomenko on 04.01.2020.
 */
@Getter
@Setter
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String categoryName;

  @ManyToMany(mappedBy = "categories")
  private Set<Recipe> recipes;

}
