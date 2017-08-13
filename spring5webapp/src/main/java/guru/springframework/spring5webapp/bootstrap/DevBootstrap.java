package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Address;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Do My Duyen on 7/27/2017.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        List<Address> address = new ArrayList<>();
        address.add(new Address("123", "Main", "FairField"));
        address.add(new Address("456", "Main", "FairField"));

        Publisher publisher = new Publisher("Foo", address);
        publisherRepository.save(publisher);

//        //Eric
//        Author eric = new Author("Eric", "Evans");
//        Book ddd = new Book("Domain Driver Design", "1234", publisher);
//        eric.getBooks().add(ddd);
//        ddd.getAuthors().add(eric);
//
//        authorRepository.save(eric);
//        bookRepository.save(ddd);


        publisherRepository.delete(publisher);
//        //Rod
//        Author rod = new Author("Rod", "Johnson");
//        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
//        rod.getBooks().add(noEJB);
//
//        authorRepository.save(rod);
//        bookRepository.save(noEJB);
    }

    public void recursiveDelele(Long id) {
        String queryChildrens = "Select * from yourtable where belongsto = '" + id + "';";
        Statement statement = dbConnection.createStatement();
        ResultSet result = statement.executeQuery(queryChildrens);
        if (result.next()) {
            while (result.next()) {
                Long childrenId = result.getLong("componentKey");
                recursiveDelele(childrenId);
            }
        }
        String queryDelete = "Delete from yourtable where componentKey = ?";
        PreparedStatement p = dbConnection.prepareStatement(queryDelete);
        p.setLong(1, id);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
