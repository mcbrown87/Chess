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

		// Diagonal Upper Right
		for(int horizontalPosition = boardLocation.GetNumericHorizontalPosition() + 1; horizontalPosition <= BoardLocation.MaxHorizontalPosition; horizontalPosition++){

			int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

			int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
			int validVerticalPosition = boardLocation.GetVerticalPosition() + diagonalConstant;

			if(validVerticalPosition > BoardLocation.MaxVerticalPosition){
				break;
			}

			validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
		}

		// Diagonal Bottom Right
		for(int horizontalPosition = boardLocation.GetNumericHorizontalPosition() + 1; horizontalPosition <= BoardLocation.MaxHorizontalPosition; horizontalPosition++){

			int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

			int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
			int validVerticalPosition = boardLocation.GetVerticalPosition() - diagonalConstant;

			if(validVerticalPosition < BoardLocation.MinVerticalPosition){
				break;
			}

			validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
		}

		// Diagonal Bottom Left
		for(int horizontalPosition = boardLocation.GetNumericHorizontalPosition() - 1; horizontalPosition >= BoardLocation.MinHorizontalPosition; horizontalPosition--){

			int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

			int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
			int validVerticalPosition = boardLocation.GetVerticalPosition() + diagonalConstant;

			if(validVerticalPosition < BoardLocation.MinVerticalPosition){
				break;
			}

			validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
		}

		// Diagonal Top Left
		for(int horizontalPosition = boardLocation.GetNumericHorizontalPosition() - 1; horizontalPosition >= BoardLocation.MinHorizontalPosition; horizontalPosition--){

			int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

			int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
			int validVerticalPosition = boardLocation.GetVerticalPosition() - diagonalConstant;

			if(validVerticalPosition < BoardLocation.MinVerticalPosition){
				break;
			}

			validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
		}

		return validMoves;
	}
}
