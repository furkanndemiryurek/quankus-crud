package service;

import entity.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import repository.impl.BookRepositoryImpl;

import java.util.List;

@ApplicationScoped
public class BookService {

    private final BookRepositoryImpl bookRepository;

    public BookService(BookRepositoryImpl bookRepository){
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book add(Book book){
        bookRepository.persist(book);
        return book;
    }

    public Book findById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> findAll(){
        return bookRepository.findAll().list();
    }

    public List<Book> findAllByAuthorName(String authorName){
        return bookRepository.findAllByAuthorName(authorName);
    }

    @Transactional
    public String deleteById(Long id){
        Book book = bookRepository.findById(id);
        if (book != null){
            bookRepository.deleteById(id);
            return "Kitap silindi : " + id;
        }else return "Kitap bulunamadı : "+ id;
    }

    @Transactional
    public Book update(Long id, Book book){
        Book existingBook = bookRepository.findById(id);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            bookRepository.persist(existingBook);
            return existingBook;
        }
        else return null;
    }

}
