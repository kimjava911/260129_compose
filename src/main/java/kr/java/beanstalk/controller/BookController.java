package kr.java.beanstalk.controller;

import kr.java.beanstalk.dto.BookForm;
import kr.java.beanstalk.entity.Book;
import kr.java.beanstalk.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @PostMapping
    public String create(BookForm form) {
        bookRepository.save(Book.builder()
                .name(form.name())
                .build());
        return "redirect:/";
    }

}
