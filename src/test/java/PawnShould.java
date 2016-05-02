import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mbrown on 4/9/16.
 */
public class PawnShould {

    @Test
    public void BeAbleToBeInstantiatedWithoutABoardLocation(){
        Pawn sut = new Pawn(ChessPiece.Colors.White);
        assertNull(sut.GetBoardLocation());
    }

    @Test
    public void AllowValidMovesWhite(){

        Pawn sut = new Pawn(ChessPiece.Colors.White, new BoardLocation('b', 2));

        assertTrue(sut.IsValidMove(new BoardLocation('b', 3)));
        assertTrue(sut.IsValidMove(new BoardLocation('b', 4)));
    }

    @Test
    public void AllowValidMovesBlack(){

        Pawn sut = new Pawn(ChessPiece.Colors.Black, new BoardLocation('e', 7));

        assertTrue(sut.IsValidMove(new BoardLocation('e', 6)));
        assertTrue(sut.IsValidMove(new BoardLocation('e', 5)));
    }

    @Test
    public void NotAllowInvalidMovesWhite(){

        Pawn sut = new Pawn(ChessPiece.Colors.White, new BoardLocation('e', 2));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 4)));
        assertFalse(sut.IsValidMove(new BoardLocation('e', 2)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 6)));

        sut.Move(new BoardLocation('e', 3), new Board());
        assertFalse(sut.IsValidMove(new BoardLocation('e', 5)));
    }

    @Test
    public void NotAllowInvalidMovesBlack(){

        Pawn sut = new Pawn(ChessPiece.Colors.Black, new BoardLocation('e', 7));

        assertFalse(sut.IsValidMove(new BoardLocation('c', 4)));
        assertFalse(sut.IsValidMove(new BoardLocation('e', 7)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 5)));
        assertFalse(sut.IsValidMove(new BoardLocation('b', 6)));

        sut.Move(new BoardLocation('e', 6), new Board());
        assertFalse(sut.IsValidMove(new BoardLocation('e', 4)));
    }

    @Test
    public void NotAllowInvalidMovesBasedOnBoardState(){

        Board board = new Board();
        board.SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation('d', 6));

        Pawn sut = new Pawn(ChessPiece.Colors.Black, new BoardLocation('c', 5));

        assertFalse(sut.IsValidMove(new BoardLocation('d', 6), board));
    }

    @Test
    public void AllowValidMovesBasedOnBoardState(){

        Board board = new Board();
        board.SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation('d', 6));

        Pawn sut = new Pawn(ChessPiece.Colors.White, new BoardLocation('e', 5));
        assertTrue(sut.IsValidMove(new BoardLocation('d', 6), board));

        sut = new Pawn(ChessPiece.Colors.White, new BoardLocation('c', 5));
        assertTrue(sut.IsValidMove(new BoardLocation('d', 6), board));
    }

    @Test
    public void NotAllowExtendedMovedIfAPieceIsBlockingIt(){

        Board board = new Board();
        board.SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation('e', 3));

        Pawn sut = new Pawn(ChessPiece.Colors.White);
        board.SetPiece(sut, new BoardLocation('e', 2));

        assertEquals(0, sut.GetValidMoves(board).size());
    }

    @Test
    public void NotAllowExtendedMovedIfOccupied(){

        Board board = new Board();
        board.SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation('e', 4));

        Pawn sut = new Pawn(ChessPiece.Colors.White);
        board.SetPiece(sut, new BoardLocation('e', 2));

        assertEquals(1, sut.GetValidMoves(board).size());
    }
}