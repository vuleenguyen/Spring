package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Do My Duyen on 7/27/2017.
 */
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="publisher_id")
    private List<Address> address;

    public Publisher() {}

    public Publisher(String name, List<Address> address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
