import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mbrown on 4/9/16.
 */
public class BoardShould {

    @Test
    public void BeInitializedProperly(){
        Board sut = new Board();

        assertEquals(64, sut.GetBoardLocations().size());
    }
}