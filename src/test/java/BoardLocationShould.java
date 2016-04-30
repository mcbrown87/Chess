import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mbrown on 4/8/16.
 */
public class BoardLocationShould {

    @Test(expected=IllegalArgumentException.class)
    public void OnlyAcceptValidHorizontalArguments(){

        new BoardLocation('1', 5);
    }

    @Test(expected=IllegalArgumentException.class)
    public void OnlyAcceptValidPositiveVerticalArguments(){

        new BoardLocation('a', -5);
    }

    @Test(expected=IllegalArgumentException.class)
    public void OnlyAcceptValidVerticalArguments(){

        new BoardLocation('a', -50);
    }

    @Test
    public void AcceptIntegerValuesForHorizontalPosition(){

        BoardLocation sut = new BoardLocation(1, 1);

        assertEquals('a', sut.GetHorizontalPosition());
    }

    @Test
    public void ReturnTheCorrectNumericHorizontalPosition(){

        assertEquals(1, new BoardLocation('a', 1).GetNumericHorizontalPosition());
        assertEquals(2, new BoardLocation('B', 1).GetNumericHorizontalPosition());
        assertEquals(3, new BoardLocation('c', 1).GetNumericHorizontalPosition());
        assertEquals(4, new BoardLocation('D', 1).GetNumericHorizontalPosition());
    }

    @Test
    public void BeEquatable(){

        assertEquals(new BoardLocation('A', 8), new BoardLocation('A', 8));
        assertNotEquals(new BoardLocation('A', 8), new BoardLocation('A', 7));
        assertNotEquals(new BoardLocation('A', 8), new BoardLocation('b', 8));
    }

    @Test
    public void DetermineIfItIsOnABoundary(){

        assertTrue(new BoardLocation('A', 5).IsOnBoundary(BoardLocation.Boundary.Left));
        assertTrue(new BoardLocation('d', 8).IsOnBoundary(BoardLocation.Boundary.Top));
        assertTrue(new BoardLocation('A', 1).IsOnBoundary(BoardLocation.Boundary.Bottom));
        assertTrue(new BoardLocation('h', 5).IsOnBoundary(BoardLocation.Boundary.Right));

        assertFalse(new BoardLocation('b', 2).IsOnBoundary(BoardLocation.Boundary.Bottom));
        assertFalse(new BoardLocation('d', 5).IsOnBoundary(BoardLocation.Boundary.Right));
    }

    @Test
    public void ImplementToString(){

        assertEquals("a5", new BoardLocation('A', 5).toString());
    }
}