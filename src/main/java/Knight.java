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

		if (boardLocation.GetNumericHorizontalPosition() < Board.MaxHorizontalPosition &&
				boardLocation.GetVerticalPosition() < Board.MaxVerticalPosition - 1) {
			validMoves.add(new BoardLocation(horizontalPosition + 1, verticalPosition + 2));
		}

		if (boardLocation.GetNumericHorizontalPosition() > Board.MinHorizontalPosition &&
				boardLocation.GetVerticalPosition() < Board.MaxVerticalPosition - 1) {
			validMoves.add(new BoardLocation(horizontalPosition - 1, verticalPosition + 2));
		}

		if (boardLocation.GetNumericHorizontalPosition() < Board.MaxHorizontalPosition &&
				boardLocation.GetVerticalPosition() > Board.MinVerticalPosition + 1) {
			validMoves.add(new BoardLocation(horizontalPosition + 1, verticalPosition - 2));
		}

		if (boardLocation.GetNumericHorizontalPosition() > Board.MinHorizontalPosition &&
				boardLocation.GetVerticalPosition() > Board.MinVerticalPosition - 1) {
			validMoves.add(new BoardLocation(horizontalPosition - 1, verticalPosition - 2));
		}

		if (boardLocation.GetNumericHorizontalPosition() < Board.MaxHorizontalPosition - 1 &&
				boardLocation.GetVerticalPosition() < Board.MaxVerticalPosition) {
			validMoves.add(new BoardLocation(horizontalPosition + 2, verticalPosition + 1));
		}

		if (boardLocation.GetNumericHorizontalPosition() < Board.MaxHorizontalPosition - 1 &&
				boardLocation.GetVerticalPosition() > Board.MinVerticalPosition) {
			validMoves.add(new BoardLocation(horizontalPosition + 2, verticalPosition - 1));
		}

		if (boardLocation.GetNumericHorizontalPosition() > Board.MinHorizontalPosition + 1 &&
				boardLocation.GetVerticalPosition() < Board.MaxVerticalPosition) {
			validMoves.add(new BoardLocation(horizontalPosition - 2, verticalPosition + 1));
		}

		if (boardLocation.GetNumericHorizontalPosition() > Board.MinHorizontalPosition + 1 &&
				boardLocation.GetVerticalPosition() > Board.MinVerticalPosition) {
			validMoves.add(new BoardLocation(horizontalPosition - 2, verticalPosition - 1));
		}

		return validMoves;
	}
}
