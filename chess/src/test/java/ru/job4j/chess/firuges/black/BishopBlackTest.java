package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void testIsDiagonalFalse() {
        BishopBlack black = new BishopBlack(Cell.D1);
        assertFalse(black.isDiagonal(Cell.D1, Cell.D3));
    }

    @Test
    public void testIsDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertTrue(bishopBlack.isDiagonal(Cell.C1, Cell.D2));
    }

    @Test
    public void testCopy() {
        BishopBlack black = new BishopBlack(Cell.A1);
        Figure figure = black.copy(Cell.C1);
        assertEquals(figure.position(), Cell.C1);
    }

    @Test
    public void testWayWhenC1ThenD2E3F4G5() {
        BishopBlack start = new BishopBlack(Cell.C1);
        Cell[] cells = start.way(Cell.H6);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5, Cell.H6};
        assertEquals(expected, cells);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenC1ToG4ThenException() {
        BishopBlack start = new BishopBlack(Cell.C1);
        Cell[] cells = start.way(Cell.G4);
    }

    @Test
    public void testPosition() {
        BishopBlack pos = new BishopBlack(Cell.E1);
        Cell tpos = pos.position();
        assertEquals(tpos, Cell.E1);
    }
}