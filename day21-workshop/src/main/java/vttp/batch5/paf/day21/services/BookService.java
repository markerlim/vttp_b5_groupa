package vttp.batch5.paf.day21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.day21.models.Book;
import vttp.batch5.paf.day21.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public List<Book> getBooksByAuthor(String author, int count) {
        return bookRepo.getBooksByAuthor(author, count);
    }

    public Optional<Book> getBookByAsin(String asin) {
        return bookRepo.getBookByAsin(asin);
    }

}
