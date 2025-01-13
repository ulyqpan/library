package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
@Table("book_loans")
public class BookLoan {
    @Id
    private Long id;
    private Long readerId;
    private Long bookId;
    private LocalDate loanDate;

    public void setReaderId(Long readerId) {
    }

    public void setBookId(Long bookId) {
    }

    public void setLoanDate(LocalDate now) {
    }

    public Long getBookId() {
        return 0L;
    }

    // Getters and Setters
}
