package africa.semicolon.quotes.services;

import africa.semicolon.quotes.dtos.UserQuoteDto;
import africa.semicolon.quotes.exceptions.QuotesException;
import africa.semicolon.quotes.models.UserQuotes;
import africa.semicolon.quotes.repositories.UserQuotesRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class UserQuotesServiceImpl implements UserQuotesService{
    private final UserQuotesRepository userQuotesRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserQuoteDto createQuote(UserQuoteDto userQuoteDtoRequest) {
        UserQuotes userQuotes = new UserQuotes();
        if(userQuoteDtoRequest.getAuthor() == null){
            userQuotes.setAuthor("UNKNOWN");
        }else{
            userQuotes.setAuthor(userQuoteDtoRequest.getAuthor());
        }
        if(userQuoteDtoRequest.getText() == null){
            throw new QuotesException("Text space is empty. Kindly input a quote");
        }
        userQuotes.setText(userQuoteDtoRequest.getText());
        userQuotes.setId(userQuotes.getId());
        UserQuotes savedQuotes = userQuotesRepository.save(userQuotes);
        return modelMapper.map(savedQuotes,UserQuoteDto.class);
    }


    @Override
    public Page<UserQuotes> findAll(int pageNumber, int noOfItems) {
        Pageable pageable = PageRequest.of(pageNumber,noOfItems);
        Page<UserQuotes> page = userQuotesRepository.findAll(pageable);
        return  page;
    }
}
