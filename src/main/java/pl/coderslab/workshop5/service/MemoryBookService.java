package pl.coderslab.workshop5.service;

import org.springframework.stereotype.Component;
import pl.coderslab.workshop5.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService implements BookService {

    private List<Book> books;

    public MemoryBookService() {
        books = new ArrayList<>();

        books.add(new Book(1L,
                "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L,"9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert",
                "Helion", "programming"));
        books.add(new Book(3L,"9780130819338","Java 2. Podstawy", "Cay Horstmann, Gary Cornell",
                "Helion", "programming"));

    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(long id) {
        Book foundBook = books.stream()
                .filter(book1 -> book1.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie ma takiej ksiazki"));

        return foundBook;
    }

    @Override
    public Book saveBook(Book book) {
        long nextId = books.stream()
                .mapToLong(Book::getId)
                .max()
                .orElse(0) + 1;
        book.setId(nextId);
        books.add(book);

        return book;
    }

    @Override
    public Book updateBook(long id, Book book) {
        Book bookToUpdate = getBookById(id);

        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setPublisher(book.getPublisher());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setType(book.getType());

        return bookToUpdate;
    }

    @Override
    public void deleteBook(long id) {
        Book bookToRemove = getBookById(id);
        books.remove(bookToRemove);
    }
}
