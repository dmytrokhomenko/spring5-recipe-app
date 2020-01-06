package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Dmytro Khomenko on 4/01/20.
 */
@Data
@Entity
public class Notes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private Recipe recipe;

  @Lob
  private String recipeNotes;

}
