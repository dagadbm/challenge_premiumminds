package com.premiumminds.pokemon.boundary;

import com.premiumminds.pokemon.controller.Pokemon;
import com.premiumminds.pokemon.controller.board.SimplifiedGameBoard;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final Pokemon pokemon = new Pokemon(new SimplifiedGameBoard());
        System.out.print(pokemon.gottaCatchEmAll(System.in));
    }
}
