package africa.semicolon.quotes.repositories;

import africa.semicolon.quotes.models.UserQuotes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserQuotesRepository extends MongoRepository<UserQuotes, String> {
    Page<UserQuotes> findUserQuotesBy (Pageable pageable);
}
