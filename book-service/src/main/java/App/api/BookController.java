package App.api;

import For.bookService.Author;
import For.bookService.Book;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starter.timer.annotation.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/book")
@Timer
public class BookController {
    private final List<Book> books;
    private final Random random = new Random();
    private final Faker faker = new Faker();

    public BookController() {
        List<Book> books = new ArrayList<>(15);

        for (int i = 0; i < 15; i++) {
            Author author = new Author();
            author.setId(UUID.randomUUID());
            author.setFirstname(faker.name().firstName());
            author.setLastname(faker.name().lastName());

            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setTitle(faker.book().title());
            book.setAuthor(author);

            books.add(book);
        }

        this.books = List.copyOf(books);
    }
    @GetMapping(path = "/all")
    public List<Book> getAllBook() {
        return books;
    }

    @GetMapping(path = "/random")
    public Book getRandomBook() {
        int index = random.nextInt(0, books.size());
        return books.get(index);
    }

}
