import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mbrown on 4/9/16.
 */
public class KnightShould {

    @Test
    public void AllowValidMoves(){

        Knight sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('e', 5));

        assertTrue(sut.IsValidMove(new BoardLocation('d', 7)));
        assertTrue(sut.IsValidMove(new BoardLocation('f', 7)));

        assertTrue(sut.IsValidMove(new BoardLocation('c', 6)));
        assertTrue(sut.IsValidMove(new BoardLocation('c', 4)));

        assertTrue(sut.IsValidMove(new BoardLocation('g', 6)));
        assertTrue(sut.IsValidMove(new BoardLocation('g', 4)));

        assertTrue(sut.IsValidMove(new BoardLocation('f', 3)));
        assertTrue(sut.IsValidMove(new BoardLocation('d', 3)));
    }

    @Test
    public void NotAllowValidMoves(){

        Knight sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('e', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 8)));
        assertFalse(sut.IsValidMove(new BoardLocation('e', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('d', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('a', 8)));
    }
}