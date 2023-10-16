package service;

import entity.Author;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import repository.impl.AuthorRepositoryImpl;

import java.util.List;

@ApplicationScoped
public class AuthorService {
    private final AuthorRepositoryImpl authorRepository;

    public AuthorService(AuthorRepositoryImpl authorRepository){
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author add(Author author){
        authorRepository.persist(author);
        return author;
    }

    public Author findById(Long id){
        return authorRepository.findById(id);
    }

    public List<Author> findAll(){
        return authorRepository.findAll().list();
    }

    @Transactional
    public String deleteById(Long id){
        Author author = authorRepository.findById(id);
        if (author != null){
            authorRepository.deleteById(id);
            return "Yazar silindi : " + id;
        }else return "Yazar bulunamadı : " + id;
    }

    @Transactional
    public Author update(Long id, Author author){
        Author existingAuthor = authorRepository.findById(id);
        if (existingAuthor != null){
            existingAuthor.setName(author.getName());
            authorRepository.persist(existingAuthor);
            return existingAuthor;
        }else return null;
    }
}
