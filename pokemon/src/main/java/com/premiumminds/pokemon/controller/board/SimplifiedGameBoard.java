package com.premiumminds.pokemon.controller.board;

import java.util.HashSet;
import java.util.Set;

/**
 * GameBoard without Coordinates class, uses less memory than the CoordinatesGameBoard
 */
public class SimplifiedGameBoard implements GameBoard {

    private int xCurrentPosition;
    private int yCurrentPosition;

    private Set<Integer> board;

    public SimplifiedGameBoard() {
        xCurrentPosition = yCurrentPosition = 0;
        board = new HashSet<>();
        addCurrentPositionToBoard();
    }

    private void addCurrentPositionToBoard() {
        board.add(Integer.valueOf(generateKey(xCurrentPosition, yCurrentPosition)));
    }

    private int generateKey(int x, int y) {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public void move(char direction) {
        switch (direction) {
            case NORTH:
                yCurrentPosition += 1;
                break;
            case SOUTH:
                yCurrentPosition -= 1;
                break;
            case EAST:
                xCurrentPosition += 1;
                break;
            case WEST:
                xCurrentPosition -= 1;
                break;
            default:
                return;
        }
        addCurrentPositionToBoard();
    }

    @Override
    public int getCapturedPokemons() {
        return board.size();
    }

    @Override
    public void reset() {
        xCurrentPosition = yCurrentPosition = 0;
        board.clear();
        addCurrentPositionToBoard();
    }

}
