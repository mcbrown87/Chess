import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mbrown on 4/16/16.
 */
public class Board {

    private Map<BoardLocation, ChessPiece> boardLocations = new HashMap<>();

    public static final int MaxVerticalPosition = 8;

    public static final int MinVerticalPosition = 1;

    public static final int MinHorizontalPosition = 1;

    public static final int MaxHorizontalPosition = 8;

    public Board() {
        Initialize();
    }

    public Board(Board board) throws InstantiationException {

        for (Map.Entry<BoardLocation, ChessPiece> entry : board.GetBoardLocations().entrySet()) {

            ChessPiece chessPiece;

            if (entry.getValue() == null) {
                chessPiece = null;
            } else {
                try {
                    chessPiece = entry.getValue().getClass().getConstructor(ChessPiece.Colors.class).newInstance
                            (entry.getValue().color);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    throw new InstantiationException();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new InstantiationException();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    throw new InstantiationException();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new InstantiationException();
                }
            }

            SetPiece(chessPiece, entry.getKey());
        }
    }

    public Map<BoardLocation, ChessPiece> GetBoardLocations() {
        return Collections.unmodifiableMap(boardLocations);
    }

    private void Initialize() {
        for (int verticalPosition = MinVerticalPosition; verticalPosition <= MaxVerticalPosition; verticalPosition++) {
            for (int horizontalPosition = MinHorizontalPosition; horizontalPosition <= MaxHorizontalPosition; horizontalPosition++) {
                SetPiece(null, new BoardLocation(horizontalPosition, verticalPosition));
            }
        }
    }

    public void Reset() {

        Initialize();

        for (int i = Board.MinHorizontalPosition; i < Board.MaxHorizontalPosition; i++) {
            SetPiece(new Pawn(ChessPiece.Colors.Black), new BoardLocation(i, 7));
            SetPiece(new Pawn(ChessPiece.Colors.White), new BoardLocation(i, 2));

            switch (i) {
                case 1:
                case 8:
                    SetPiece(new Rook(ChessPiece.Colors.Black), new BoardLocation(i, 8));
                    SetPiece(new Rook(ChessPiece.Colors.White), new BoardLocation(i, 1));
                    break;

                case 2:
                case 7:
                    SetPiece(new Knight(ChessPiece.Colors.Black), new BoardLocation(i, 8));
                    SetPiece(new Knight(ChessPiece.Colors.White), new BoardLocation(i, 1));
                    break;

                case 3:
                case 6:
                    SetPiece(new Bishop(ChessPiece.Colors.Black), new BoardLocation(i, 8));
                    SetPiece(new Bishop(ChessPiece.Colors.White), new BoardLocation(i, 1));
                    break;

                case 4:
                    SetPiece(new Queen(ChessPiece.Colors.Black), new BoardLocation(i, 8));
                    SetPiece(new Queen(ChessPiece.Colors.White), new BoardLocation(i, 1));
                    break;

                case 5:
                    SetPiece(new King(ChessPiece.Colors.Black), new BoardLocation(i, 8));
                    SetPiece(new King(ChessPiece.Colors.White), new BoardLocation(i, 1));
                    break;
            }
        }
    }

    public void SetPiece(ChessPiece chessPiece, BoardLocation boardLocation) {

        if (chessPiece != null) {
            chessPiece.SetBoardLocation(boardLocation);
        }

        boardLocations.put(boardLocation, chessPiece);
    }

    public void RemovePiece(BoardLocation boardLocation){
        boardLocations.put(boardLocation, null);
    }

    public boolean IsCheck(ChessPiece.Colors color) {

        King king = GetKing(color);

        if(king == null){
            return false;
        }

        for (Map.Entry<BoardLocation, ChessPiece> entry : GetBoardLocations().entrySet()) {

            ChessPiece chessPiece = entry.getValue();

            if (chessPiece == null) {
                continue;
            }

            if(chessPiece.color != color && chessPiece.GetValidMoves().contains(king.GetBoardLocation())) {
                return true;
            }
        }

        return false;
    }

    private King GetKing(ChessPiece.Colors color) {

        for (Map.Entry<BoardLocation, ChessPiece> entry : GetBoardLocations().entrySet()) {

            if (entry.getValue() instanceof King) {
                return (King) entry.getValue();
            }
        }

        return null;
    }
}
