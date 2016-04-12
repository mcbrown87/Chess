import java.util.ArrayList;

public abstract class ChessPiece {
	public enum Colors {
		Black,
		White
	}

	private Colors color;

	protected BoardLocation boardLocation;

	public ChessPiece(Colors color, BoardLocation boardLocation) {
		this.color = color;
		this.boardLocation = boardLocation;
	}

	public BoardLocation GetBoardLocation(){
		return boardLocation;
	}

	public boolean IsValidMove(BoardLocation proposedBoardLocation){
		return GetValidMoves().contains(proposedBoardLocation);
	}

	public abstract ArrayList<BoardLocation> GetValidMoves();
}