package com.kiet.Library.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kiet.Library.model.Book;
import com.kiet.Library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // Q3: Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    // Q3: Get book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(
            @PathVariable int bookId) {

        Book book = service.getBookById(bookId);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(book);
    }

    // Q4: Add a new book
    @PostMapping
    public ResponseEntity<Book> addBook(
            @RequestBody Book book) {

        service.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(book);
    }

    // Q5: Update a book
    @PutMapping("/{bookId}")
    public ResponseEntity<Map<String, String>> updateBook(
            @PathVariable int bookId,
            @RequestBody Book updatedBook) {

        String result = service.updateBook(bookId, updatedBook);

        if (result.equals("Book not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", result));
        }

        return ResponseEntity.ok(Map.of("message", result));
    }

    // Q5: Delete a book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Map<String, String>> deleteBook(
            @PathVariable int bookId) {

        String result = service.deleteBook(bookId);

        if (result.equals("Book not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", result));
        }

        return ResponseEntity.ok(Map.of("message", result));
    }

    // Q6: Search books by category
    @GetMapping("/search")
    public List<Book> searchByCategory(
            @RequestParam String category) {

        return service.searchByCategory(category);
    }

    // Q6: Find books published from a year onward
    @GetMapping("/published")
    public List<Book> findPublishedFromYear(
            @RequestParam int fromYear) {

        return service.findPublishedFromYear(fromYear);
    }
}
