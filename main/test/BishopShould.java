import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mbrown on 4/9/16.
 */
public class BishopShould {

    @Test
    public void AllowValidMoves(){

        Bishop sut = new Bishop(ChessPiece.Colors.Black, new BoardLocation('e', 5));

        assertTrue(sut.IsValidMove(new BoardLocation('f', 6)));
        assertTrue(sut.IsValidMove(new BoardLocation('g', 7)));
        assertTrue(sut.IsValidMove(new BoardLocation('d', 4)));

        assertTrue(sut.IsValidMove(new BoardLocation('d', 6)));
        assertTrue(sut.IsValidMove(new BoardLocation('b', 8)));
        assertTrue(sut.IsValidMove(new BoardLocation('g', 3)));
    }

    @Test
    public void NotAllowValidMoves(){

        Bishop sut = new Bishop(ChessPiece.Colors.Black, new BoardLocation('e', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 4)));
        assertFalse(sut.IsValidMove(new BoardLocation('e', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('d', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('a', 8)));
    }
}