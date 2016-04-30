import java.util.regex.Pattern;


/**
 * Created by mbrown on 4/8/16.
 */
public class BoardLocation {

    public enum Boundary{
        Top,
        Bottom,
        Left,
        Right
    }

    private int verticalPosition;

    private char horizontalPosition;

    public BoardLocation(char horizontalPosition, int verticalPosition){

        SetVerticalPosition(verticalPosition);
        SetHorizontalPosition(horizontalPosition);
    }

    public BoardLocation(int horizontalPosition, int verticalPosition) {
        this(IntegerToChar(horizontalPosition), verticalPosition);
    }

    public int GetVerticalPosition() {
        return verticalPosition;
    }

    public char GetHorizontalPosition(){
        return horizontalPosition;
    }

    public int GetNumericHorizontalPosition(){

        return ((int)GetHorizontalPosition()) - 96;
    }

    public void SetVerticalPosition(int verticalPosition){

        if(verticalPosition > 8 || verticalPosition < 1)
            throw new IllegalArgumentException("verticalPosition must be between 1 and 8");

        this.verticalPosition = verticalPosition;
    }

    public void SetHorizontalPosition(char horizontalPosition){

        horizontalPosition = Character.toLowerCase(horizontalPosition);

        if(!Pattern.matches("[a-h]", String.valueOf(horizontalPosition)))
            throw new IllegalArgumentException("horizontalPosition must be between a-h");

        this.horizontalPosition = horizontalPosition;
    }

    public boolean IsOnBoundary(Boundary boundary){

        switch(boundary) {
            case Top:
                return GetVerticalPosition() == Board.MaxVerticalPosition;

            case Bottom:
                return GetVerticalPosition() == Board.MinVerticalPosition;

            case Right:
                return GetNumericHorizontalPosition() == Board.MaxHorizontalPosition;

            case Left:
                return GetNumericHorizontalPosition() == Board.MinHorizontalPosition;

            default:
                throw new IllegalStateException(String.format("No detection logic defined for boundary '%s'", boundary.toString()));
        }
    }

    @Override
    public boolean equals(Object object) {

        boolean sameSame = false;

        if (object != null && object instanceof BoardLocation) {
            sameSame = GetHorizontalPosition() == ((BoardLocation) object).GetHorizontalPosition() &&
                        GetVerticalPosition() == ((BoardLocation) object).GetVerticalPosition();
        }

        return sameSame;
    }

    @Override
    public int hashCode(){
        return GetVerticalPosition() ^ GetNumericHorizontalPosition();
    }

    @Override
    public String toString(){
        return GetHorizontalPosition() + String.valueOf(GetVerticalPosition());
    }

    private static char IntegerToChar(int integer){

        return (char)(integer+96);
    }
}
