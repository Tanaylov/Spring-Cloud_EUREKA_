package For.bookService;

import lombok.Data;

import java.util.UUID;

@Data
public class Book {
    private UUID id;
    private String title;
    private Author author;
}
