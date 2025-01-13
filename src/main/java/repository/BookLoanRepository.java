package repository;

import model.BookLoan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookLoanRepository extends CrudRepository<BookLoan, Long> {
    List<BookLoan> findByReaderId(Long readerId);
}

