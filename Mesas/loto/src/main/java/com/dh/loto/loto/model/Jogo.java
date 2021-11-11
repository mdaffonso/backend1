package com.dh.loto.loto.model;

import lombok.Getter;

import java.util.*;

@Getter
public class Jogo {

    List<String> jogos = new ArrayList<>();

    public Jogo(Integer k) {
        Random random = new Random();
        SortedSet<String> numbers;

        for (int j = 0; j < k; j++) {
            numbers = new TreeSet<>();
            while (numbers.size() < 6) {
                String n = String.valueOf(random.nextInt(1, 60));
                n = n.length() == 2 ? n : "0" + n;
                numbers.add(n);
            }

            jogos.add(String.join(" ", numbers));
        }
    }
}
