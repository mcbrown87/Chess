import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public abstract class ChessPiece implements Cloneable{
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
			throw new IllegalStateException(String.format("A move to '%s' is invalid for %s", boardLocation, this));
		}

		board.SetPiece(this, boardLocation);
	}

	public Colors GetColor(){
		return color;
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

	public abstract ArrayList<BoardLocation> GetValidMoves();

	public ArrayList<BoardLocation> GetValidMoves(Board board) {

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

		return RemoveMovesThatWouldCauseCheck(validMoves, board);
	}

	private ArrayList<BoardLocation> RemoveMovesThatWouldCauseCheck(ArrayList<BoardLocation> validMoves, Board board) {

        ArrayList<BoardLocation> adjustedValidMoves = new ArrayList<>(validMoves);

        Iterator<BoardLocation> iterator = validMoves.iterator();
        while (iterator.hasNext()) {

            BoardLocation validMove = iterator.next();

            Board potentialBoard;
            try {
                potentialBoard = new Board(board);
            } catch (InstantiationException e) {
                e.printStackTrace();
                throw new IllegalStateException();
            }

            // Find the piece on the potential board that matches this one
            for (Map.Entry<BoardLocation, ChessPiece> entry : potentialBoard.GetBoardLocations().entrySet()) {

                ChessPiece chessPiece = entry.getValue();
                if (chessPiece != null && chessPiece.equals(this)) {
                    potentialBoard.RemovePiece(entry.getKey());
                    break;
                }
            }

            if (potentialBoard.IsCheck(GetColor())) {

                adjustedValidMoves.remove(validMove);
            }
        }

        return adjustedValidMoves;
    }


    @Override
    public boolean equals(Object object) {

        boolean sameSame = false;
        ChessPiece otherChessPiece = (ChessPiece)object;

        if (object != null && object instanceof ChessPiece) {
            sameSame = otherChessPiece.getClass() == getClass() && otherChessPiece.GetColor() == GetColor();
            if (otherChessPiece.GetBoardLocation() != null && GetBoardLocation() != null) {
                sameSame = otherChessPiece.GetBoardLocation().equals(GetBoardLocation());
            } else if (otherChessPiece.GetBoardLocation() != null || GetBoardLocation() != null) {
                sameSame = false;
            }
        }

        return sameSame;
    }

    @Override
    public int hashCode(){
        return GetColor().hashCode() ^ GetBoardLocation().hashCode();
    }

    @Override
	public String toString(){
		return String.format("[%s] %s", color.toString(), getClass().getName());
	}
}