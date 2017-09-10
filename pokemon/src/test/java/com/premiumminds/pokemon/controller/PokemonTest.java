package com.premiumminds.pokemon.controller;

import com.premiumminds.pokemon.controller.board.CoordinatesGameBoard;
import com.premiumminds.pokemon.controller.board.SimplifiedGameBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokemonTest {
    
    private Pokemon underTest;
    private PipedInputStream inputStream;
    private PipedOutputStream writer;

    @Before
    public void setUp() throws Exception {
        inputStream = new PipedInputStream();
        writer = new PipedOutputStream(inputStream);
    }

    @After
    public void tearDown() throws Exception {
        inputStream.close();
        writer.close();
    }

    @Test
    public void testInput1() throws Exception {
        underTest = new Pokemon(new CoordinatesGameBoard());
        final String input = "E";
        writeToStream(input + "\n");
        final int result = underTest.gottaCatchEmAll(inputStream);
        assertThat(result, is(2));
    }

    @Test
    public void testInput2() throws Exception {
        underTest = new Pokemon(new SimplifiedGameBoard());
        final String input = "NESO";
        writeToStream(input + "\n");
        final int result = underTest.gottaCatchEmAll(inputStream);
        assertThat(result, is(4));
    }

    @Test
    public void testInput3() throws Exception {
        underTest = new Pokemon(new CoordinatesGameBoard());
        final String input = "NSNSNSNSNS";
        writeToStream(input + "\n");
        final int result = underTest.gottaCatchEmAll(inputStream);
        assertThat(result, is(2));
    }

    private void writeToStream(String content) throws IOException {
        writer.write(content.getBytes());
    }
}
