package repository;
import entity.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

public interface AuthorRepository extends PanacheRepository<Author> {
}
