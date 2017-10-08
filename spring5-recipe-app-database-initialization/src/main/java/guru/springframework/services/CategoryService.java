package guru.springframework.services;

import guru.springframework.domain.Category;

import java.util.Set;

/**
 * Created by Do My Duyen on 8/22/2017.
 */
public interface CategoryService {

    public Set<Category> getCategories();
}
