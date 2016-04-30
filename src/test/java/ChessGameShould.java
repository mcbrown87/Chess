import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mbrown on 4/9/16.
 */
public class ChessGameShould {

    @Test
    public void InitiallyHaveAnInProgressState() {

        ChessGame sut = new ChessGame();
        sut.Restart();
        assertEquals(ChessGame.GameStates.InProgress, sut.GetGameState());
    }

    @Test
    public void DetectBlackCheckmated() {

        Board board = new Board();
        ChessGame sut = new ChessGame(board);

        King king = Mockito.mock(King.class);
        Mockito.when(king.GetValidMoves()).thenReturn(new ArrayList<BoardLocation>());
        Mockito.when(king.GetColor()).thenReturn(ChessPiece.Colors.Black);

        board.SetPiece(king, new BoardLocation('a', 5));

        assertEquals(ChessGame.GameStates.BlackCheckmated, sut.GetGameState());
    }

    @Test
    public void DetectWhiteCheckmated() {

        Board board = new Board();
        ChessGame sut = new ChessGame(board);

        King king = Mockito.mock(King.class);
        Mockito.when(king.GetValidMoves()).thenReturn(new ArrayList<BoardLocation>());
        Mockito.when(king.GetColor()).thenReturn(ChessPiece.Colors.White);

        board.SetPiece(king, new BoardLocation('a', 5));

        assertEquals(ChessGame.GameStates.WhiteCheckmated, sut.GetGameState());
    }
}