package controller;

import model.Reader;
import service.ReaderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping
    public void addReader(@RequestBody Reader reader) {
        readerService.addReader(reader);
    }
}
