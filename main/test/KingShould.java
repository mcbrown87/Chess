import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mbrown on 4/8/16.
 */
public class KingShould {

    @Test
    public void DetectValidMoves() {

        King sut = new King(ChessPiece.Colors.Black, new BoardLocation('d', 3));

        assertTrue(sut.IsValidMove(new BoardLocation('d', 2)));
        assertTrue(sut.IsValidMove(new BoardLocation('d', 4)));
        assertTrue(sut.IsValidMove(new BoardLocation('c', 3)));
        assertTrue(sut.IsValidMove(new BoardLocation('e', 3)));
    }

    @Test
    public void DetectInvalidMoves(){

        King kingOnTopOfBoard = new King(ChessPiece.Colors.Black, new BoardLocation('d', 8));
        King kingOnBottomOfBoard = new King(ChessPiece.Colors.Black, new BoardLocation('d', 1));
        King kingOnLeftOfBoard = new King(ChessPiece.Colors.Black, new BoardLocation('a', 5));
        King kingOnRightOfBoard = new King(ChessPiece.Colors.Black, new BoardLocation('h', 5));

        assertFalse(kingOnTopOfBoard.IsValidMove(new BoardLocation('e', 6)));
        assertFalse(kingOnBottomOfBoard.IsValidMove(new BoardLocation('f', 8)));
        assertFalse(kingOnLeftOfBoard.IsValidMove(new BoardLocation('h', 5)));
        assertFalse(kingOnRightOfBoard.IsValidMove(new BoardLocation('a', 1)));
    }
}