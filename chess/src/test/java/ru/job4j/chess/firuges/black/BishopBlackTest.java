package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {
    @Test
    public void testIsDiagonalFalse() {
        BishopBlack black = new BishopBlack(Cell.D1);
        assertThat(black.isDiagonal(Cell.D1, Cell.D3), is(false));
    }

    @Test
    public void testIsDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.D2), is(true));

    }

    @Test
    public void testCopy() {
        BishopBlack black = new BishopBlack(Cell.A1);
        Figure figure = black.copy(Cell.C1);
        assertThat(figure.position(), is(Cell.C1));
    }

    @Test
    public void testWayWhenC1ThenD2E3F4G5() {
        BishopBlack start = new BishopBlack(Cell.C1);
        Cell[] cells = start.way(Cell.H6);
        assertThat(cells[0], is(Cell.D2));
        assertThat(cells[1], is(Cell.E3));
        assertThat(cells[2], is(Cell.F4));
        assertThat(cells[3], is(Cell.G5));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenC1ToG4ThenException() {
        BishopBlack start = new BishopBlack(Cell.C1);
        Cell[] cells = start.way(Cell.G4);
    }
}