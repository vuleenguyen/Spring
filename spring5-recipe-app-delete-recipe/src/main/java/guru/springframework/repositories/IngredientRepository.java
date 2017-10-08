package guru.springframework.repositories;

import guru.springframework.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Do My Duyen on 10/7/2017.
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
