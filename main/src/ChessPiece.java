import java.util.ArrayList;
import java.util.Iterator;

public abstract class ChessPiece {
	public enum Colors {
		Black,
		White
	}

	private Colors color;

	protected BoardLocation boardLocation;

	public ChessPiece(Colors color, BoardLocation boardLocation) {
		this.color = color;
		SetBoardLocation(boardLocation);
	}

	public void SetBoardLocation(BoardLocation boardLocation){
		this.boardLocation = boardLocation;
	}

	public boolean IsValidMove(BoardLocation boardLocation){
		return IsValidMove(boardLocation, new Board());
	}

	public boolean IsValidMove(BoardLocation proposedBoardLocation, Board board){
		return GetValidMoves(board).contains(proposedBoardLocation);
	}

	protected abstract ArrayList<BoardLocation> GetValidMoves();

	protected ArrayList<BoardLocation> GetValidMoves(Board board) {

		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		Iterator<BoardLocation> iterator = GetValidMoves().iterator();

		while(iterator.hasNext()){
			BoardLocation validMove = iterator.next();

			ChessPiece pieceAtProposedMove = board.GetBoardLocations().get(validMove);

			if(pieceAtProposedMove != null && pieceAtProposedMove.color != color){
				validMoves.add(validMove);
			}
		}

		return validMoves;
	}

	@Override
	public String toString(){
		return String.format("[%s] %s", color.toString(), getClass().getName());
	}
}