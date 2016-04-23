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

    public Board(){
        Initialize();
    }

    public Map<BoardLocation, ChessPiece> GetBoardLocations(){
        return Collections.unmodifiableMap(boardLocations);
    }

    private void Initialize() {
        for (int verticalPosition = MinVerticalPosition; verticalPosition <= MaxVerticalPosition; verticalPosition++) {
            for (int horizontalPosition = MinHorizontalPosition; horizontalPosition <= MaxHorizontalPosition; horizontalPosition++) {
                SetPiece(null, new BoardLocation(horizontalPosition, verticalPosition));
            }
        }
    }

    public void SetPiece(ChessPiece chessPiece, BoardLocation boardLocation) {

        if (chessPiece != null) {
            chessPiece.SetBoardLocation(boardLocation);
        }

        boardLocations.put(boardLocation, chessPiece);
    }
}
