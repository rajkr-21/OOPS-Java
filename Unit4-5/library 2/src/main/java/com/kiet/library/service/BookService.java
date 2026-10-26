
package com.kiet.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.library.model.Book;
import com.kiet.library.Repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBookById(int id) {
        List<Book> result = repo.findById(id);
        return result.isEmpty() ? null : result.get(0);
    }

    public boolean addBook(Book book) {
        return repo.insert(book) > 0;
    }

    public boolean updateBook(int id, Book book) {
        return repo.update(book, id) > 0;
    }

    public boolean deleteBook(int id) {
        return repo.deleteById(id) > 0;
    }

    public List<Book> searchByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Book> findPublishedFromYear(int year) {
        return repo.findPublishedFromYear(year);
    }
}
