import java.util.ArrayList;

public class Knight extends ChessPiece {

	public Knight(Colors color){
		this(color, null);
	}

	public Knight(Colors color, BoardLocation boardLocation) {
		super(color, boardLocation);
	}

	@Override
	public ArrayList<BoardLocation> GetValidMoves() {
		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		int horizontalPosition = boardLocation.GetNumericHorizontalPosition();
		int verticalPosition = boardLocation.GetVerticalPosition();

		validMoves.add(new BoardLocation(horizontalPosition + 1, verticalPosition + 2));
		validMoves.add(new BoardLocation(horizontalPosition - 1, verticalPosition + 2));
		validMoves.add(new BoardLocation(horizontalPosition + 1, verticalPosition - 2));
		validMoves.add(new BoardLocation(horizontalPosition - 1, verticalPosition - 2));
		validMoves.add(new BoardLocation(horizontalPosition + 2, verticalPosition + 1));
		validMoves.add(new BoardLocation(horizontalPosition + 2, verticalPosition - 1));
		validMoves.add(new BoardLocation(horizontalPosition - 2, verticalPosition + 1));
		validMoves.add(new BoardLocation(horizontalPosition - 2, verticalPosition - 1));

		return validMoves;
	}
}
