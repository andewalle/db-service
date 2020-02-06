package com.example.dbservice.resource;
import com.example.dbservice.model.Quote;
import com.example.dbservice.model.Quotes;
import com.example.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")

public class DbServiceResource {

    private QuotesRepository quotesRepository;

    public DbServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username")
                                  final String username) {
        return getQuotesByUserName(username);
    }

    @PostMapping
    public List<String> add(@RequestBody final Quotes quotes) {
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(), quote))
                .forEach(quote ->
                        quotesRepository.save(quote));
               return getQuotesByUserName(quotes.getUserName());
    }

    @PostMapping("/{username}")
        public List<String> delete (@PathVariable("username") final String username) {

            List<Quote> quotes = quotesRepository.findByUserName(username);
            quotesRepository.deleteAll(quotes);
            return getQuotesByUserName(username);

        }

    private List<String> getQuotesByUserName(@PathVariable("username") String username) {
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }
}
