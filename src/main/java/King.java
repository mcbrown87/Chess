import java.util.ArrayList;

public class King extends ChessPiece {

	public King(Colors color){
		this(color, null);
	}

	public King(Colors color, BoardLocation boardLocation) {
		super(color, boardLocation);
	}

	@Override
	public ArrayList<BoardLocation> GetValidMoves() {
		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		if (!boardLocation.IsOnBoundary(BoardLocation.Boundary.Right)) {
			validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() + 1, boardLocation.GetVerticalPosition()));

			if(!boardLocation.IsOnBoundary(BoardLocation.Boundary.Top)){
				validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() + 1, boardLocation.GetVerticalPosition() + 1));
			}

			if(!boardLocation.IsOnBoundary(BoardLocation.Boundary.Bottom)){
				validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() + 1, boardLocation.GetVerticalPosition() - 1));
			}
		}

		if (!boardLocation.IsOnBoundary(BoardLocation.Boundary.Left)) {
			validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() - 1, boardLocation.GetVerticalPosition()));

			if(!boardLocation.IsOnBoundary(BoardLocation.Boundary.Top)){
				validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() - 1, boardLocation.GetVerticalPosition() + 1));
			}

			if(!boardLocation.IsOnBoundary(BoardLocation.Boundary.Bottom)){
				validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() - 1, boardLocation.GetVerticalPosition() - 1));
			}
		}

		if (!boardLocation.IsOnBoundary(BoardLocation.Boundary.Top)) {
			validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition(), boardLocation.GetVerticalPosition() + 1));

			if(!boardLocation.IsOnBoundary(BoardLocation.Boundary.Left)){
				validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() - 1, boardLocation.GetVerticalPosition() + 1));
			}

			if(!boardLocation.IsOnBoundary(BoardLocation.Boundary.Right)){
				validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() + 1, boardLocation.GetVerticalPosition() + 1));
			}
		}

		if (!boardLocation.IsOnBoundary(BoardLocation.Boundary.Bottom)) {
			validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition(), boardLocation.GetVerticalPosition() - 1));

			if(!boardLocation.IsOnBoundary(BoardLocation.Boundary.Left)){
				validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() - 1, boardLocation.GetVerticalPosition() - 1));
			}

			if(!boardLocation.IsOnBoundary(BoardLocation.Boundary.Right)){
				validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() + 1, boardLocation.GetVerticalPosition() - 1));
			}
		}

		return validMoves;
	}
}
