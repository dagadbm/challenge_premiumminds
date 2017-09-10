package com.premiumminds.pokemon.controller;

import com.premiumminds.pokemon.controller.board.GameBoard;

import java.io.IOException;
import java.io.InputStream;

public class Pokemon {

    private static final char LINE_SEPARATOR = '\n';

    private GameBoard gameBoard;

    public Pokemon(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int gottaCatchEmAll(InputStream inputStream) throws IOException {
        int ch;
        while ((ch = inputStream.read()) != LINE_SEPARATOR) {
            gameBoard.move((char) ch);
        }
        return gameBoard.getCapturedPokemons();
    }
}
