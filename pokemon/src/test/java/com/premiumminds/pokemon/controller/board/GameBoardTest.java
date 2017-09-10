package com.premiumminds.pokemon.controller.board;

import com.premiumminds.pokemon.controller.board.CoordinatesGameBoard;
import com.premiumminds.pokemon.controller.board.GameBoard;
import com.premiumminds.pokemon.controller.board.SimplifiedGameBoard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class GameBoardTest {

    private GameBoard underTest;

    public GameBoardTest(GameBoard gameBoard) {
        underTest = gameBoard;
    }

    @Before
    public void setUp() throws Exception {
        underTest.reset();
    }

    @Test
    public void testInput1() throws Exception {
        final String input = "E";
        walk(input);
        final int result = underTest.getCapturedPokemons();
        assertThat(result, is(2));
    }

    @Test
    public void testInput2() throws Exception {
        final String input = "NESO";
        walk(input);
        final int result = underTest.getCapturedPokemons();
        assertThat(result, is(4));
    }

    @Test
    public void testInput3() throws Exception {
        final String input = "NSNSNSNSNS";
        walk(input);
        final int result = underTest.getCapturedPokemons();
        assertThat(result, is(2));
    }

    @Test
    public void emptyInput() throws Exception {
        final int result = underTest.getCapturedPokemons();
        assertThat(result, is(1));
    }

    @Test
    public void longInputNoRepeatedSteps() throws Exception {
        final int steps = 5_000_000;
        walk(steps, underTest.NORTH);
        final int result = underTest.getCapturedPokemons();
        assertThat(result, is(steps + 1));
    }

    @Test
    public void longInputWithRepeatedSteps() throws Exception {
        final int size = 1_000_000;
        for (int i = 0; i < size; i++) {
            walk(20, underTest.SOUTH);
            walk(20, underTest.EAST);
            walk(20, underTest.WEST);
            walk(20, underTest.NORTH);
        }
        final int result = underTest.getCapturedPokemons();
        assertThat(result, is(40 + 1));
    }

    @Test
    public void squareMotion() throws Exception {
        for (int i = 0; i < 5; i++) {
            walk(20, underTest.NORTH);
            walk(20, underTest.EAST);
            walk(20, underTest.SOUTH);
            walk(20, underTest.WEST);
        }
        final int result = underTest.getCapturedPokemons();
        assertThat(result, is(20 * 4));
    }

    @Test
    public void contraryMotion() throws Exception {
        for (int i = 0; i < 5; i++) {
            walk(20, underTest.NORTH);
            walk(20, underTest.SOUTH);
        }
        final int result = underTest.getCapturedPokemons();
        assertThat(result, is(20 + 1));
    }

    private void walk(String path) {
        for (char direction : path.toCharArray()) {
            underTest.move(direction);
        }
    }

    private void walk(int steps, char direction) {
        for (int i = 0; i < steps; i++) {
            underTest.move(direction);
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new CoordinatesGameBoard()},
                new Object[]{new SimplifiedGameBoard()});
    }
}