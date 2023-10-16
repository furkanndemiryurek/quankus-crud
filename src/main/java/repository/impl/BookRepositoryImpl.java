package repository.impl;

import entity.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import repository.BookRepository;

import java.util.List;
@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Book> findAllByAuthorName(String authorName) {
        String hql = "SELECT b FROM Book b JOIN b.author a WHERE a.name = :authorName";
        return entityManager.createQuery(hql, Book.class)
                .setParameter("authorName", authorName)
                .getResultList();
    }
}
