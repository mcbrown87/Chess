import org.junit.Test;
import sun.plugin.dom.exception.InvalidStateException;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

/**
 * Created by mbrown on 4/9/16.
 */
public class KnightShould {

    @Test
    public void BeAbleToBeInstantiatedWithoutABoardLocation(){
        Knight sut = new Knight(ChessPiece.Colors.White);
        assertNull(sut.GetBoardLocation());
    }

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
    public void NotAllowInvalidMoves(){

        Knight sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('e', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 8)));
        assertFalse(sut.IsValidMove(new BoardLocation('e', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('d', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('a', 8)));
    }

    @Test(expected = InvalidStateException.class)
    public void ThrowForAnInvalidMove(){
        Knight sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('g', 6));

        sut.Move(new BoardLocation('h', 7), new Board());
    }

    @Test
    public void NotAllowInvalidMovesBasedOnBoardState(){

        Board board = new Board();
        board.SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation('g', 6));

        Knight sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('e', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('g', 6), board));
    }

    @Test
    public void NotAllowInvalidMovesBasedOnBoundaries(){

        Knight sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('a', 8));
        assertEquals(2, sut.GetValidMoves().size());

        sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('h', 8));
        assertEquals(2, sut.GetValidMoves().size());

        sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('a', 1));
        assertEquals(2, sut.GetValidMoves().size());

        sut = new Knight(ChessPiece.Colors.Black, new BoardLocation('h', 8));
        assertEquals(2, sut.GetValidMoves().size());
    }

}