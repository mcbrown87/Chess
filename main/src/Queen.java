import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {

	public Queen(Colors color, BoardLocation boardLocation) {
		super(color, boardLocation);
	}

	@Override
	public Boolean IsValidMove(BoardLocation proposedBoardLocation) {

		List<BoardLocation> validMoves = new ArrayList<>();

		for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition(); horizontalPosition <= 8; horizontalPosition++) {

			validMoves.add(new BoardLocation(horizontalPosition, boardLocation.GetVerticalPosition()));
		}

		for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition(); horizontalPosition >= 1; horizontalPosition++) {

			validMoves.add(new BoardLocation(horizontalPosition, boardLocation.GetVerticalPosition()));
		}


		return validMoves.contains(proposedBoardLocation);
	}
}
