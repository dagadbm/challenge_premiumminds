package com.premiumminds.pokemon.controller.board;

/**
 * Immutable class to represent coordinates (x,y) on a board
 */
class Coordinates {

    public final int x;
    public final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;

        Coordinates coordinates = (Coordinates) o;

        return x == coordinates.x && y == coordinates.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
