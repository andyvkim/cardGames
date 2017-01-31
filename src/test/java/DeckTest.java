import org.junit.Assert;
import org.junit.Test;
import Kim.Andy.CardGames.*;
import java.util.ArrayList;
import java.util.Stack;


public class DeckTest {
    Deck testDeck = new Deck();

    ArrayList<Card> testHand = new ArrayList<Card>();


    @Test
    public void drawCardTest(){
        testDeck.drawCard(testHand);
        int expected = 1;
        int actual = testHand.size();
        Assert.assertEquals("I expect player hand to have one card", expected, actual);

    }



    }


