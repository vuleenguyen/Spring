package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 6/21/17.
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand implements Comparable<CategoryCommand> {
    private Long id;
    private String description;

    @Override
    public int compareTo(CategoryCommand o) {
        return this.description.compareTo(o.getDescription());
    }
}
