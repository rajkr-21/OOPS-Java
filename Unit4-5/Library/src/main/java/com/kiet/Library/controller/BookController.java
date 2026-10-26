
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

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(
            @PathVariable int bookId) {

        Book b = service.getBookById(bookId);

        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(b);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        if (service.addBook(book)) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(book);
        }

        return ResponseEntity.badRequest()
                .body(Map.of("message", "Book could not be added"));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Map<String, String>> updateBook(
            @PathVariable int bookId,
            @RequestBody Book book) {

        if (service.updateBook(bookId, book)) {
            return ResponseEntity.ok(
                    Map.of("message", "Book updated successfully"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Book not found"));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Map<String, String>> deleteBook(
            @PathVariable int bookId) {

        if (service.deleteBook(bookId)) {
            return ResponseEntity.ok(
                    Map.of("message", "Book deleted successfully"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Book not found"));
    }

    @GetMapping("/search")
    public List<Book> searchByCategory(
            @RequestParam String category) {
        return service.searchByCategory(category);
    }

    @GetMapping("/published")
    public List<Book> findPublishedFromYear(
            @RequestParam int fromYear) {
        return service.findPublishedFromYear(fromYear);
    }
}
