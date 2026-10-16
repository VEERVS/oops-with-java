
package com.example.LibraryManagement.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.service.BookService;

@RestController
@RequestMapping("/books")
 public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET: Retrieve all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // GET: Retrieve book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(
            @PathVariable int bookId) {

        Optional<Book> book =
                bookService.getBookById(bookId);

        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Book not found"));
    }

    // POST: Add a new book
    @PostMapping
    public ResponseEntity<?> addBook(
            @RequestBody Book book) {

        boolean added = bookService.addBook(book);

        if (!added) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message",
                            "Book could not be added. "
                            + "Check the request or use a unique bookId."));
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(book);
    }

    // PUT: Update an existing book
    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(
            @PathVariable int bookId,
            @RequestBody Book updatedBook) {

        Optional<Book> book =
                bookService.updateBook(bookId, updatedBook);

        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Book not found"));
    }

    // DELETE: Delete a book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Map<String, String>> deleteBook(
            @PathVariable int bookId) {

        boolean deleted = bookService.deleteBook(bookId);

        if (deleted) {
            return ResponseEntity.ok(
                    Map.of("message",
                            "Book deleted successfully"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Book not found"));
    }

    // GET: Search books by category
    @GetMapping("/search")
    public ResponseEntity<?> searchByCategory(
            @RequestParam String category) {

        List<Book> result =
                bookService.searchByCategory(category);

        if (result.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of("message",
                            "No books found in this category"));
        }

        return ResponseEntity.ok(result);
    }

    // GET: Filter books by publication year
    @GetMapping("/published")
    public ResponseEntity<?> findPublishedFromYear(
            @RequestParam int fromYear) {

        List<Book> result =
                bookService.findPublishedFromYear(fromYear);

        if (result.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of("message",
                            "No books found from the specified year onward"));
        }

        return ResponseEntity.ok(result);
    }
}
