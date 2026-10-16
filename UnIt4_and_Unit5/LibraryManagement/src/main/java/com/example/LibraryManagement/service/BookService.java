
package com.example.LibraryManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.model.Book;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(201, "Effective Java",
                "Joshua Bloch", "Programming", 2018, true));

        books.add(new Book(202, "Clean Code",
                "Robert C. Martin", "Programming", 2008, true));

        books.add(new Book(203, "The Hobbit",
                "J.R.R. Tolkien", "Fantasy", 1937, false));

        books.add(new Book(204, "Wings of Fire",
                "A.P.J. Abdul Kalam", "Biography", 1999, true));

        books.add(new Book(205, "The Pragmatic Programmer",
                "Andrew Hunt", "Programming", 1999, true));
    }

    // Get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Get book by ID
    public Optional<Book> getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    // Add book
    public boolean addBook(Book book) {
        if (book == null ||
                getBookById(book.getBookId()).isPresent()) {
            return false;
        }

        books.add(book);
        return true;
    }

    // Update book
    public Optional<Book> updateBook(
            int bookId, Book updatedBook) {

        if (updatedBook == null) {
            return Optional.empty();
        }

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                updatedBook.setBookId(bookId);
                books.set(i, updatedBook);
                return Optional.of(updatedBook);
            }
        }

        return Optional.empty();
    }

    // Delete book
    public boolean deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                books.remove(i);
                return true;
            }
        }

        return false;
    }

    // Search books by category
    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory() != null
                    && category != null
                    && book.getCategory()
                           .equalsIgnoreCase(category.trim())) {
                result.add(book);
            }
        }

        return result;
    }

    // Find books published from a given year
    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublicationYear() >= fromYear) {
                result.add(book);
            }
        }

        return result;
    }
}
