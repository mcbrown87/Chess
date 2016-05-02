import org.junit.Test;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mbrown on 4/9/16.
 */
public class BoardShould {

    @Test
    public void BeInitializedProperly(){
        Board sut = new Board();

        assertEquals(64, sut.GetBoardLocations().size());
    }

    @Test
    public void SetChessPieces(){
        Board sut = new Board();

        BoardLocation initialBoardLocation = new BoardLocation('a', 4);
        Rook myRook = new Rook(ChessPiece.Colors.Black, initialBoardLocation);

        assertEquals(initialBoardLocation, myRook.GetBoardLocation());

        BoardLocation newBoardLocation = new BoardLocation('a', 5);
        sut.SetPiece(myRook, newBoardLocation);

        assertEquals(newBoardLocation, myRook.GetBoardLocation());
    }

    @Test
    public void BeAbleToReset(){

        Board sut = new Board();
        BoardLocation boardLocation = new BoardLocation('d', 5);

        assertNull(sut.GetBoardLocations().get(boardLocation));
        sut.SetPiece(new Rook(ChessPiece.Colors.Black), boardLocation);
        assertNotNull(sut.GetBoardLocations().get(boardLocation));

        sut.Reset();
        assertNull(sut.GetBoardLocations().get(boardLocation));
    }

    @Test
    public void BeClonable(){

        Board board1 = new Board();
        board1.Reset();
        Board board2 = null;
        try {
            board2 = new Board(board1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        assertNotSame(board1, board2);
        assertEquals(board1.GetBoardLocations(), board2.GetBoardLocations());

        assertNotSame(board1.GetBoardLocations().get(new BoardLocation('a', 1)), board2.GetBoardLocations().get(new
                BoardLocation('a', 1)));
    }

    @Test
    public void DetectCheckStates(){

        Board sut = new Board();

        King whiteKing = new King(ChessPiece.Colors.White);
        Queen blackQueen = new Queen(ChessPiece.Colors.Black);

        sut.SetPiece(whiteKing, new BoardLocation('c', 3));
        sut.SetPiece(blackQueen, new BoardLocation('e', 4));

        assertFalse(sut.IsCheck(ChessPiece.Colors.White));

        blackQueen.Move(new BoardLocation('e', 3), sut);

        assertTrue(sut.IsCheck(ChessPiece.Colors.White));
    }
}