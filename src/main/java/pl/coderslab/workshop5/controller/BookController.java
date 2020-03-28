package pl.coderslab.workshop5.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.workshop5.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/test")
    public Book getBook() {
        Book book = new Book
                (1, "isbn123123", "Dzuma", "Albert Camis", "ItaliaPublicatta", "ksiazka");

        return book;
    }

}
