import java.util.ArrayList;

/**
 * Created by mbrown on 4/11/16.
 */
class SharedValidMoves {

    static ArrayList<BoardLocation> GetDiagonalMoves(BoardLocation boardLocation) {
        ArrayList<BoardLocation> validMoves = new ArrayList<>();

        // Diagonal Upper Right
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() + 1; horizontalPosition <= Board.MaxHorizontalPosition; horizontalPosition++) {

            int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

            int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
            int validVerticalPosition = boardLocation.GetVerticalPosition() + diagonalConstant;

            if (validVerticalPosition > Board.MaxVerticalPosition) {
                break;
            }

            validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
        }

        // Diagonal Bottom Right
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() + 1; horizontalPosition <= Board.MaxHorizontalPosition; horizontalPosition++) {

            int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

            int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
            int validVerticalPosition = boardLocation.GetVerticalPosition() - diagonalConstant;

            if (validVerticalPosition < Board.MinVerticalPosition) {
                break;
            }

            validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
        }

        // Diagonal Bottom Left
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() - 1; horizontalPosition >= Board.MinHorizontalPosition; horizontalPosition--) {

            int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

            int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
            int validVerticalPosition = boardLocation.GetVerticalPosition() + diagonalConstant;

            if (validVerticalPosition < Board.MinVerticalPosition) {
                break;
            }

            validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
        }

        // Diagonal Top Left
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() - 1; horizontalPosition >= Board.MinHorizontalPosition; horizontalPosition--) {

            int diagonalConstant = horizontalPosition - boardLocation.GetNumericHorizontalPosition();

            int validHorizontalPosition = boardLocation.GetNumericHorizontalPosition() + diagonalConstant;
            int validVerticalPosition = boardLocation.GetVerticalPosition() - diagonalConstant;

            if (validVerticalPosition > Board.MaxVerticalPosition) {
                break;
            }

            validMoves.add(new BoardLocation(validHorizontalPosition, validVerticalPosition));
        }

        return validMoves;
    }

    static ArrayList<BoardLocation> GetLateralMoves(BoardLocation boardLocation) {

        ArrayList<BoardLocation> validMoves = new ArrayList<>();

        // Horizontal
        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() + 1; horizontalPosition <= Board.MaxHorizontalPosition; horizontalPosition++) {

            validMoves.add(new BoardLocation(horizontalPosition, boardLocation.GetVerticalPosition()));
        }

        for (int horizontalPosition = boardLocation.GetNumericHorizontalPosition() - 1; horizontalPosition >= Board.MinHorizontalPosition; horizontalPosition--) {

            validMoves.add(new BoardLocation(horizontalPosition, boardLocation.GetVerticalPosition()));
        }

        // Vertical
        for (int verticalPosition = boardLocation.GetVerticalPosition() + 1; verticalPosition <= Board.MaxVerticalPosition; verticalPosition++) {

            validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition(), verticalPosition));
        }

        for (int verticalPosition = boardLocation.GetVerticalPosition() - 1; verticalPosition >= Board.MinHorizontalPosition; verticalPosition--) {

            validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition(), verticalPosition));
        }

        return validMoves;
    }
}
