package com.premiumminds.pokemon.controller.board;

import com.premiumminds.pokemon.controller.board.Coordinates;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class CoordinatesTest {
    @Test
    public void sameCoordinatesSameObject() throws Exception {
        final Coordinates c1 = new Coordinates(5, 5);
        final Coordinates c2 = c1;

        assertThat(c1, is(c1));
        assertThat(c2, is(c2));
        assertThat(c1, is(c2));
        assertThat(c2, is(c1));

        assertThat(c1.hashCode(), is(c1.hashCode()));
        assertThat(c2.hashCode(), is(c2.hashCode()));
        assertThat(c1.hashCode(), is(c2.hashCode()));
        assertThat(c2.hashCode(), is(c1.hashCode()));
    }

    @Test
    public void sameCoordinatesDifferentObject() throws Exception {
        final Coordinates c1 = new Coordinates(-1, -1);
        final Coordinates c2 = new Coordinates(-1, -1);

        assertThat(c1, is(c2));
        assertThat(c2, is(c1));
        assertThat(c1.hashCode(), is(c2.hashCode()));
        assertThat(c2.hashCode(), is(c1.hashCode()));
    }

    @Test
    public void differentCoordinates() throws Exception {
        final Coordinates c1 = new Coordinates(-1, 1);
        final Coordinates c2 = new Coordinates(1, -1);

        assertThat(c1, not(c2));
        assertThat(c1.hashCode(), not(c2.hashCode()));
    }
}