package App.api;

import App.model.Issue;
import App.service.BookProvider;
import App.service.ReaderProvider;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping(path = "/api/issue")
public class IssueController {

    private final List<Issue> issues;
    private final Faker faker = new Faker();

    public IssueController(BookProvider bookProvider, ReaderProvider readerProvider) {
        List<Issue> issues = new ArrayList<>(15);

        for (int i = 0; i < 15; i++) {

            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());

            LocalDate between = faker.date()
                    .between(startOfYear(), endOfYear())
                    .toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            issue.setIssuedAt(between);
            issue.setBook(bookProvider.getRandomBook());
            issue.setReader(readerProvider.getRandomReader());

            issues.add(issue);
        }

        this.issues = List.copyOf(issues);
    }
    @GetMapping(path = "/all")
    public List<Issue> getAllIssue() {
        return issues;
    }

    private Date startOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.JANUARY);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        return instance.getTime();
    }
    private Date endOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.DECEMBER);
        instance.set(Calendar.DAY_OF_MONTH, 31);
        return instance.getTime();
    }
}

