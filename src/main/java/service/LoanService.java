package service;

import model.Book;
import model.BookLoan;
import repository.BookLoanRepository;
import repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
    private final BookLoanRepository bookLoanRepository;
    private final BookRepository bookRepository;

    public LoanService(BookLoanRepository bookLoanRepository, BookRepository bookRepository) {
        this.bookLoanRepository = bookLoanRepository;
        this.bookRepository = bookRepository;
    }

    public void loanBook(Long readerId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);

            BookLoan bookLoan = new BookLoan();
            bookLoan.setReaderId(readerId);
            bookLoan.setBookId(bookId);
            bookLoan.setLoanDate(LocalDate.now());
            bookLoanRepository.save(bookLoan);
        } else {
            throw new RuntimeException("No available copies");
        }
    }

    public void returnBook(Long loanId) {
        BookLoan bookLoan = bookLoanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
        Book book = bookRepository.findById(bookLoan.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));

        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        bookLoanRepository.delete(bookLoan);
    }

    public List<BookLoan> getBooksByReader(Long readerId) {
        return bookLoanRepository.findByReaderId(readerId);
    }
}
