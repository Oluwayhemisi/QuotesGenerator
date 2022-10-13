package africa.semicolon.quotes.services;

import africa.semicolon.quotes.dtos.UserQuoteDto;
import africa.semicolon.quotes.models.UserQuotes;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface UserQuotesService {
    UserQuoteDto createQuote (UserQuoteDto userQuoteDtoRequest);
    Page<UserQuotes> findAll(int pageNumber, int noOfItems);
}
