package africa.semicolon.quotes.controllers;


import africa.semicolon.quotes.dtos.ApiResponse;
import africa.semicolon.quotes.dtos.UserQuoteDto;
import africa.semicolon.quotes.models.UserQuotes;
import africa.semicolon.quotes.services.UserQuotesService;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/userQuotes/")
@AllArgsConstructor
public class UserQuotesController {
    private final UserQuotesService userQuotesService;


    @PostMapping("create/")
    public ResponseEntity<?> create(@RequestBody UserQuoteDto userQuoteDto){

        UserQuoteDto userQuoteDto1 = userQuotesService.createQuote(userQuoteDto);
        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(userQuoteDto1)
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }
    @GetMapping("{pageNumber}/{noOfItems}")
    public ResponseEntity<?> getAll (@PathVariable int pageNumber,@PathVariable int noOfItems){
        Page<UserQuotes> userQuotes = userQuotesService.findAll(pageNumber,noOfItems);
        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(userQuotes)
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }
}
