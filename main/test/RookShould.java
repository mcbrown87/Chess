import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mbrown on 4/9/16.
 */
public class RookShould {

    @Test
    public void AllowValidMoves(){

        Rook sut = new Rook(ChessPiece.Colors.Black, new BoardLocation('b', 5));

        assertTrue(sut.IsValidMove(new BoardLocation('b', 6)));
        assertTrue(sut.IsValidMove(new BoardLocation('b', 7)));
        assertTrue(sut.IsValidMove(new BoardLocation('b', 4)));

        assertTrue(sut.IsValidMove(new BoardLocation('d', 5)));
        assertTrue(sut.IsValidMove(new BoardLocation('a', 5)));
        assertTrue(sut.IsValidMove(new BoardLocation('g', 5)));
    }

    @Test
    public void NotAllowValidMoves(){

        Rook sut = new Rook(ChessPiece.Colors.Black, new BoardLocation('c', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('e', 6)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 7)));
        assertFalse(sut.IsValidMove(new BoardLocation('d', 3)));
        assertFalse(sut.IsValidMove(new BoardLocation('a', 8)));
    }

    @Test
    public void NotAllowValidMovesBasedOnBoardState(){

        Board board = new Board();
        board.SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation('c', 6));

        Rook sut = new Rook(ChessPiece.Colors.Black, new BoardLocation('c', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 6), board));
    }
}