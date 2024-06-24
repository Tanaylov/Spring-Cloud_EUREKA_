package For.readerService;

import lombok.Data;

import java.util.UUID;

@Data
public class Reader {
    private UUID id;
    private String firstname;
    private String lastname;
}
