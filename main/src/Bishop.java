import java.util.ArrayList;

public class Bishop extends ChessPiece {

	public Bishop(Colors color){
		this(color, null);
	}

	public Bishop(Colors color, BoardLocation boardLocation) {
		super(color, boardLocation);
	}

	@Override
	public ArrayList<BoardLocation> GetValidMoves() {
		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		validMoves.addAll(SharedValidMoves.GetDiagonalMoves(boardLocation));

		return validMoves;
	}
}
