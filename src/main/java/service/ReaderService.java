package service;

import model.Reader;
import repository.ReaderRepository;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public void addReader(Reader reader) {
        readerRepository.save(reader);
    }
}
