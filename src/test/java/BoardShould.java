import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
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
}