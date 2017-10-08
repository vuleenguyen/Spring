package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Do My Duyen on 8/21/2017.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
