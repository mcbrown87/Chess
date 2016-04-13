import java.util.ArrayList;

public class Rook extends ChessPiece {

	public Rook(Colors color, BoardLocation boardLocation) {
		super(color, boardLocation);
	}

	@Override
	public ArrayList<BoardLocation> GetValidMoves() {
		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		validMoves.addAll(SharedValidMoves.GetLateralMoves(boardLocation));

		return validMoves;
	}
}
