package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        Random gerador = new Random();
        List<Integer> listMegaSena = new ArrayList<Integer>();

        for (int i = 0; i < 6; i++) {
            listMegaSena.add(gerador.nextInt(99));
        }
        listMegaSena.sort(Comparator.naturalOrder());
        return listMegaSena;
    }
}
