import java.util.ArrayList;

/**
 * Created by mbrown on 4/11/16.
 */
public class SharedValidMoves {

    public static ArrayList<BoardLocation> GetDiagonalMoves(BoardLocation boardLocation) {
        ArrayList<BoardLocation> validMoves = new ArrayList<>();

        // Diagonal Upper Right
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() + 1; horizontalPosition <= BoardLocation.MaxHorizontalPosition; horizontalPosition++) {

            int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

            int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
            int validVerticalPosition = boardLocation.GetVerticalPosition() + diagonalConstant;

            if (validVerticalPosition > BoardLocation.MaxVerticalPosition) {
                break;
            }

            validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
        }

        // Diagonal Bottom Right
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() + 1; horizontalPosition <= BoardLocation.MaxHorizontalPosition; horizontalPosition++) {

            int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

            int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
            int validVerticalPosition = boardLocation.GetVerticalPosition() - diagonalConstant;

            if (validVerticalPosition < BoardLocation.MinVerticalPosition) {
                break;
            }

            validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
        }

        // Diagonal Bottom Left
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() - 1; horizontalPosition >= BoardLocation.MinHorizontalPosition; horizontalPosition--) {

            int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

            int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
            int validVerticalPosition = boardLocation.GetVerticalPosition() + diagonalConstant;

            if (validVerticalPosition < BoardLocation.MinVerticalPosition) {
                break;
            }

            validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
        }

        // Diagonal Top Left
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() - 1; horizontalPosition >= BoardLocation.MinHorizontalPosition; horizontalPosition--) {

            int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

            int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
            int validVerticalPosition = boardLocation.GetVerticalPosition() - diagonalConstant;

            if (validVerticalPosition > BoardLocation.MaxVerticalPosition) {
                break;
            }

            validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
        }

        return validMoves;
    }
}
