import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {

	public Queen(Colors color, BoardLocation boardLocation) {
		super(color, boardLocation);
	}

	@Override
	public ArrayList GetValidMoves() {

		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		// Horizontal
		for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() + 1; horizontalPosition <= BoardLocation.MaxHorizontalPosition; horizontalPosition++) {

			validMoves.add(new BoardLocation(horizontalPosition, boardLocation.GetVerticalPosition()));
		}

		for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() - 1; horizontalPosition >= BoardLocation.MinHorizontalPosition; horizontalPosition--) {

			validMoves.add(new BoardLocation(horizontalPosition, boardLocation.GetVerticalPosition()));
		}

		// Vertical
		for (int verticalPosition = boardLocation.GetVerticalPosition() + 1; verticalPosition <= BoardLocation.MaxVerticalPosition; verticalPosition++) {

			validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition(), verticalPosition));
		}

		for (int verticalPosition = boardLocation.GetNumericHorizontalPosition() - 1; verticalPosition >= BoardLocation.MinHorizontalPosition; verticalPosition--) {

			validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition(), verticalPosition));
		}

		validMoves.addAll(SharedValidMoves.GetDiagonalMoves(boardLocation));

		return validMoves;
	}
}
