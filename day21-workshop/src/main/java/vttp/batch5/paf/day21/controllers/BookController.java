package vttp.batch5.paf.day21.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vttp.batch5.paf.day21.models.Book;
import vttp.batch5.paf.day21.services.BookService;

@Controller
@RequestMapping
public class BookController {

    @Autowired
    private BookService bookSvc;

    @GetMapping("/book/{asin}")
    public ModelAndView getBookByAsin(@PathVariable String asin
        , @RequestParam String author, @RequestParam(defaultValue="10") int count) {

        ModelAndView mav = new ModelAndView("book-detail");
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required=true) String author
            , @RequestParam(defaultValue="10") int count ) {

        List<Book> books = bookSvc.getBooksByAuthor(author, count);

        ModelAndView mav = new ModelAndView("search-result");
        mav.addObject("author", author);
        mav.addObject("count", count);
        mav.addObject("books", books);
        mav.setStatus(HttpStatusCode.valueOf(200));

        return mav;
    }

}
