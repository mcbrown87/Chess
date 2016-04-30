import java.util.Iterator;
import java.util.Map;

public class ChessGame {

	private Board board;

	public ChessGame(){
		this(new Board());
	}

	public ChessGame(Board board){
		this.board = board;
	}

	public void Restart(){
		board.Reset();
	}

	public GameStates GetGameState(){

		Iterator<Map.Entry<BoardLocation, ChessPiece>> iterator = board.GetBoardLocations().entrySet().iterator();
		while(iterator.hasNext()) {
			ChessPiece chessPiece = iterator.next().getValue();

			if(chessPiece == null){
				continue;
			}

			if (chessPiece instanceof King && chessPiece.GetValidMoves().size() == 0) {
				return chessPiece.GetColor() == ChessPiece.Colors.Black ? GameStates.BlackCheckmated :
						GameStates.WhiteCheckmated;
			}
		}

		return GameStates.InProgress;
	}

	public enum GameStates{
		InProgress,
		WhiteCheckmated,
		BlackCheckmated,
		Stalemate
	}
}
