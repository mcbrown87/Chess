import java.util.ArrayList;

public class Queen extends ChessPiece {

	public Queen(Colors color){
		this(color, null);
	}

	public Queen(Colors color, BoardLocation boardLocation) {
		super(color, boardLocation);
	}

	@Override
	public ArrayList GetValidMoves() {

		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		validMoves.addAll(SharedValidMoves.GetLateralMoves(boardLocation));
		validMoves.addAll(SharedValidMoves.GetDiagonalMoves(boardLocation));

		return validMoves;
	}
}
