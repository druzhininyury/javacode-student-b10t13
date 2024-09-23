package ru.javacode.student.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yury")
public class YuryController {

    @GetMapping
    public String getYury() {
        return "Bingo!";
    }

}
