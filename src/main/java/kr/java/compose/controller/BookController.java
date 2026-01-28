package kr.java.compose.controller;

import kr.java.compose.dto.BookForm;
import kr.java.compose.entity.Book;
import kr.java.compose.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @Value("${app.name}")
    private String appName;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("appName", appName);
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
