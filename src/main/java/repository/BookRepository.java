package repository;

import entity.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface BookRepository extends PanacheRepository<Book> {
    List<Book> findAllByAuthorName(String authorName);
}
