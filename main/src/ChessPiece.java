import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ChessPiece {
	public enum Colors {
		Black,
		White
	}

	protected Colors color;

	protected BoardLocation boardLocation;

	public ChessPiece(Colors color, BoardLocation boardLocation) {
		this.color = color;
		this.boardLocation = boardLocation;
	}

	void SetBoardLocation(BoardLocation boardLocation){
		this.boardLocation = boardLocation;
	}

	public void Move(BoardLocation boardLocation, Board board){
		if(!IsValidMove(boardLocation, board)){
			throw new InvalidStateException(String.format("A move to '%s' is invalid for %s", boardLocation, this));
		}

		board.SetPiece(this, boardLocation);
	}

	public BoardLocation GetBoardLocation(){
		return boardLocation;
	}

	public boolean IsValidMove(BoardLocation boardLocation){
		return IsValidMove(boardLocation, new Board());
	}

	public boolean IsValidMove(BoardLocation boardLocation, Board board){
		return GetValidMoves(board).contains(boardLocation);
	}

	protected abstract ArrayList<BoardLocation> GetValidMoves();

	protected ArrayList<BoardLocation> GetValidMoves(Board board) {

		ArrayList<BoardLocation> validMoves = new ArrayList<>();

		Iterator<BoardLocation> iterator = GetValidMoves().iterator();

		// Remove all invalid moves based on board location
		while(iterator.hasNext()) {
			BoardLocation validMove = iterator.next();

			ChessPiece pieceAtProposedMove = board.GetBoardLocations().get(validMove);

			if (pieceAtProposedMove != null && pieceAtProposedMove.color == color) {
				continue;
			}

			validMoves.add(validMove);
		}

		return validMoves;
	}

	@Override
	public String toString(){
		return String.format("[%s] %s", color.toString(), getClass().getName());
	}
}