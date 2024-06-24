package app.api;

import For.readerService.Reader;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(path = "/api/reader")
public class ReaderController {

    private final List<Reader> readers;
    private final Random random = new Random();
    private final Faker faker = new Faker();

    public ReaderController() {
        List<Reader> readers = new ArrayList<>(15);

        for (int i = 0; i < 15; i++) {
            Reader reader = new Reader();
            reader.setId(UUID.randomUUID());
            reader.setFirstname(faker.name().firstName());
            reader.setLastname(faker.name().lastName());

            readers.add(reader);
        }

        this.readers = List.copyOf(readers);
    }


    @GetMapping(path = "/all")
    public List<Reader> getAllReaders() {
        return readers;
    }

    @GetMapping(path = "/random")
    public Reader getRandomReader() {
        return readers.get(random.nextInt(readers.size()));
    }

}
