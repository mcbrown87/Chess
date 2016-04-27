import org.junit.Test;
import sun.plugin.dom.exception.InvalidStateException;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mbrown on 4/9/16.
 */
public class BishopShould {

    @Test
    public void BeAbleToBeInstantiatedWithoutABoardLocation(){
        Bishop sut = new Bishop(ChessPiece.Colors.White);
        assertNull(sut.GetBoardLocation());
    }

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
    public void NotAllowInvalidMoves(){

        Bishop sut = new Bishop(ChessPiece.Colors.Black, new BoardLocation('e', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 4)));
        assertFalse(sut.IsValidMove(new BoardLocation('e', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('d', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('a', 8)));
    }

    @Test
    public void NotAllowInvalidMovesBasedOnBoardState(){

        Board board = new Board();
        board.SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation('d', 6));

        Bishop sut = new Bishop(ChessPiece.Colors.Black, new BoardLocation('c', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('d', 6), board));
    }

    @Test(expected = InvalidStateException.class)
    public void ThrowForAnInvalidMove(){
        Bishop sut = new Bishop(ChessPiece.Colors.Black, new BoardLocation('g', 6));

        sut.Move(new BoardLocation('h', 1), new Board());
    }
}