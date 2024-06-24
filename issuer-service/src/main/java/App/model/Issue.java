package App.model;

import For.bookService.Book;
import For.readerService.Reader;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Issue {

    private UUID id;
    private Book book;
    private Reader reader;

    private LocalDate issuedAt;


}
