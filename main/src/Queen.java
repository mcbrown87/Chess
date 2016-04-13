import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {

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