package com.dh.loto.loto.controller;

import com.dh.loto.loto.model.Jogo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mega")
public class JogoController {

    @GetMapping("jogar")
    public Jogo novo() {
        return new Jogo(1);
    }

    @GetMapping("jogar/{n}")
    public Jogo novo(@PathVariable Integer n) {
        return new Jogo(n);
    }
}
