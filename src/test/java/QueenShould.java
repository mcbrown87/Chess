import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mbrown on 4/9/16.
 */
public class QueenShould {

    @Test
    public void BeAbleToBeInstantiatedWithoutABoardLocation(){
        Queen sut = new Queen(ChessPiece.Colors.White);
        assertNull(sut.GetBoardLocation());
    }

    @Test
    public void AllowValidMoves(){

        Queen sut = new Queen(ChessPiece.Colors.Black, new BoardLocation('c', 3));

        assertTrue(sut.IsValidMove(new BoardLocation('c', 2)));
        assertTrue(sut.IsValidMove(new BoardLocation('c', 5)));
        assertTrue(sut.IsValidMove(new BoardLocation('c', 8)));

        assertTrue(sut.IsValidMove(new BoardLocation('b', 3)));
        assertTrue(sut.IsValidMove(new BoardLocation('a', 3)));
        assertTrue(sut.IsValidMove(new BoardLocation('h', 3)));

        assertTrue(sut.IsValidMove(new BoardLocation('d', 4)));
        assertTrue(sut.IsValidMove(new BoardLocation('g', 7)));
        assertTrue(sut.IsValidMove(new BoardLocation('a', 1)));

        assertTrue(sut.IsValidMove(new BoardLocation('a', 5)));
        assertTrue(sut.IsValidMove(new BoardLocation('e', 1)));
        assertTrue(sut.IsValidMove(new BoardLocation('d', 2)));
    }

    @Test
    public void NotAllowInvalidMoves(){

        Queen sut = new Queen(ChessPiece.Colors.Black, new BoardLocation('c', 3));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 3)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('d', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('a', 8)));
    }
}