import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}