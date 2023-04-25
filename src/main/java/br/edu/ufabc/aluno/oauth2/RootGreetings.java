package br.edu.ufabc.aluno.oauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootGreetings {
    @GetMapping("/")
    public String index() {
        return "Hello!";
    }
}
