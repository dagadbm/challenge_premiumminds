package com.premiumminds.pokemon.controller.board;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  GameBoard implementation using Coordinates class instead of Integers (uses more memory)
 */
public class CoordinatesGameBoard implements GameBoard {

    private static final Coordinates START_COORDINATES = new Coordinates(0, 0);

    private static final Map<Character, Coordinates> directionCoordinates = new HashMap<>();

    static {
        directionCoordinates.put(NORTH, new Coordinates(0, 1));
        directionCoordinates.put(SOUTH, new Coordinates(0, -1));
        directionCoordinates.put(EAST, new Coordinates(1, 0));
        directionCoordinates.put(WEST, new Coordinates(-1, 0));
    }

    private Coordinates currentPosition;
    private Set<Coordinates> board;

    public CoordinatesGameBoard() {
        currentPosition = START_COORDINATES;
        board = new HashSet<>();
        board.add(currentPosition);
    }

    @Override
    public void move(char direction) {
        currentPosition = addCoordinates(currentPosition, directionCoordinates.get(direction));
        board.add(currentPosition);
    }

    private Coordinates addCoordinates(Coordinates p1, Coordinates p2) {
        return new Coordinates(p1.x + p2.x, p1.y + p2.y);
    }

    @Override
    public int getCapturedPokemons() {
        return board.size();
    }

    @Override
    public void reset() {
        currentPosition = START_COORDINATES;
        board.clear();
        board.add(currentPosition);
    }
}
