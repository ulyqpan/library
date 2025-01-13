package controller;

import model.BookLoan;
import service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loan")
    public void loanBook(@RequestParam Long readerId, @RequestParam Long bookId) {
        loanService.loanBook(readerId, bookId);
    }

    @PostMapping("/return")
    public void returnBook(@RequestParam Long loanId) {
        loanService.returnBook(loanId);
    }

    @GetMapping("/{readerId}")
    public List<BookLoan> getBooksByReader(@PathVariable Long readerId) {
        return loanService.getBooksByReader(readerId);
    }
}
