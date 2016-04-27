import java.util.ArrayList;
import java.util.Iterator;

public class Pawn extends ChessPiece {

	private boolean isFirstMove = true;

	public Pawn(Colors color) {
		this(color, null);
	}

	public Pawn(Colors color, BoardLocation boardLocation) {
		super(color, boardLocation);
	}

	@Override
	public void Move(BoardLocation boardLocation, Board board) {
		super.Move(boardLocation, board);
		isFirstMove = false;
	}

	@Override
	public ArrayList<BoardLocation> GetValidMoves() {
		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		int verticalPosition = boardLocation.GetVerticalPosition() + (GetDirectionMultiplier() * 1);

		if (verticalPosition < Board.MaxVerticalPosition && verticalPosition > Board.MinVerticalPosition) {
			validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition(), verticalPosition));
		}

		if (isFirstMove) {
			validMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition(), boardLocation
					.GetVerticalPosition() + (GetDirectionMultiplier()
					* 2)));
		}

		return validMoves;
	}

	@Override
	public ArrayList<BoardLocation> GetValidMoves(Board board){

		ArrayList<BoardLocation> validMoves = super.GetValidMoves(board);

		ArrayList<BoardLocation> attackMoves = new ArrayList<>();

		attackMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() + 1, boardLocation
				.GetVerticalPosition() + GetDirectionMultiplier()));

		attackMoves.add(new BoardLocation(boardLocation.GetNumericHorizontalPosition() - 1, boardLocation
				.GetVerticalPosition() + GetDirectionMultiplier()));

		Iterator<BoardLocation> iterator = attackMoves.iterator();

		// Check for valid attack moves
		while(iterator.hasNext()) {
			BoardLocation attackMove = iterator.next();

			ChessPiece pieceAtProposedMove = board.GetBoardLocations().get(attackMove);

			if(pieceAtProposedMove != null && pieceAtProposedMove.color != color){
				validMoves.add(attackMove);
			}
		}

		return validMoves;
	}

	private int GetDirectionMultiplier() {
		return color == Colors.White ? 1 : -1;
	}
}
