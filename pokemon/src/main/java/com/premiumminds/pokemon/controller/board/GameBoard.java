package com.premiumminds.pokemon.controller.board;

/**
 * Pokemon gaming board. Each movement will capture a pokemon.
 */
public interface GameBoard {

    char NORTH = 'N';
    char SOUTH = 'S';
    char EAST = 'E';
    char WEST = 'O';

    /**
     * Move via a given direction and capture a pokemon.
     * Possible values are NORTH, SOUTH, EAST and WEST
     */
    void move(char direction);

    /**
     * Get the total of captured pokemons so far
     */
    int getCapturedPokemons();

    /**
     * Reset the status of the game board, clearing all captured pokemons and movements.
     */
    void reset();
}
