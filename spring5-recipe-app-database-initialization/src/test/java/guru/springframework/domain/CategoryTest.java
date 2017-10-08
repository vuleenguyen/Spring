package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Do My Duyen on 8/21/2017.
 */
public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        category.setId(4l);
        assertEquals(new Long(4l), category.getId());
    }

    @Test
    public void getDescription() throws Exception {
        category.setDescription("This is category");
        assertEquals("This is category", category.getDescription());
    }

    @Test
    public void getRecipes() throws Exception {
        category.setRecipes(new HashSet<>(Arrays.asList(new Recipe())));
        assertNotNull(category.getRecipes().iterator().next());
    }

}