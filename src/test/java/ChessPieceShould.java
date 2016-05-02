import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by mbrown on 4/9/16.
 */
public class ChessPieceShould {

    @Test
    public void NotAllowInvalidMovesBasedOnCheck(){

        Board board = new Board();

        board.SetPiece(new King(ChessPiece.Colors.White), new BoardLocation('e', 4));
        Knight sut = new Knight(ChessPiece.Colors.White);
        board.SetPiece(sut, new BoardLocation('e', 5));

        board.SetPiece(new Queen(ChessPiece.Colors.Black), new BoardLocation('e', 6));

        assertEquals(0, sut.GetValidMoves(board).size());
    }

    @Test(expected=IllegalStateException.class)
    public void ThrowForAnInvalidMove() {

        Rook sut = new Rook(ChessPiece.Colors.Black, new BoardLocation('c', 5));

        sut.Move(new BoardLocation('c', 5), new Board());
    }

    @Test
    public void NotAllowInvalidMovesBasedOnBoardState(){

        Board board = new Board();
        board.SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation('c', 6));

        Rook sut = new Rook(ChessPiece.Colors.Black, new BoardLocation('c', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 6), board));
    }

    @Test
    public void BeEquatable(){

        assertEquals(new King(ChessPiece.Colors.Black), new King(ChessPiece.Colors.Black));
        assertEquals(new King(ChessPiece.Colors.Black, new BoardLocation('a', 1)), new King(ChessPiece.Colors.Black,
                new BoardLocation('a', 1)));

        assertNotEquals(new King(ChessPiece.Colors.Black), new King(ChessPiece.Colors.White));
        assertNotEquals(new King(ChessPiece.Colors.Black, new BoardLocation('a', 1)), new King(ChessPiece.Colors.Black,
                new BoardLocation('a', 2)));

        assertNotEquals(new King(ChessPiece.Colors.White), new Knight(ChessPiece.Colors.White));
        assertNotEquals(new King(ChessPiece.Colors.White), new King(ChessPiece.Colors.White, new BoardLocation('a',
                1)));
    }
}