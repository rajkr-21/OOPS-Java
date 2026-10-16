package com.kiet.Library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.kiet.Library.model.Book;

@Service
public class BookService {

    List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                return b;
            }
        }
        return null;
    }

    public String addBook(Book book) {
        books.add(book);
        return "Book added successfully";
    }

    public String updateBook(int bookId, Book updatedBook) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
                b.setCategory(updatedBook.getCategory());
                b.setPublicationYear(updatedBook.getPublicationYear());
                b.setAvailable(updatedBook.isAvailable());
                return "Book updated successfully";
            }
        }
        return "Book not found";
    }

    public String deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                books.remove(i);
                return "Book deleted successfully";
            }
        }
        return "Book not found";
    }

    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book b : books) {
            if (b.getCategory().equalsIgnoreCase(category)) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book b : books) {
            if (b.getPublicationYear() >= fromYear) {
                result.add(b);
            }
        }
        return result;
    }
}
