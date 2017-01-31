import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Kim.Andy.CardGames.*;
import java.util.ArrayList;

public class GoFishTest {

    GoFish goFish;
    ArrayList<Card> playerHand;
    ArrayList<Card> dealerHand;
    Card aceTest;
    Card kingTest;
    Card queenTest;

    @Before
    public void setUp() {
        goFish = new GoFish();
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
        aceTest = new Card('A');
        kingTest = new Card('K');
        queenTest = new Card('Q');
    }

    @Test
    public void fourOfAKindTest(){
        playerHand.add(aceTest);
        playerHand.add(aceTest);
        playerHand.add(aceTest);
        playerHand.add(kingTest);
        playerHand.add(aceTest);
        boolean expected = true;
        boolean actual = goFish.fourOfAKind(playerHand, new Card('A'));
        Assert.assertEquals("I expect it to return true because there are 4 aces", expected,actual);
    }
    @Test
    public void removeCardsFromPlayTest(){
        playerHand.add(aceTest);
        playerHand.add(queenTest);
        playerHand.add(aceTest);
        playerHand.add(kingTest);
        playerHand.add(aceTest);
        playerHand.add(queenTest);
        playerHand.add(aceTest);
        goFish.removeCardsFromPlay(playerHand, aceTest, 0);
        System.out.println(goFish.displayCard(playerHand));
        int expected = 3;
        int actual = playerHand.size();
        Assert.assertEquals("I expect this to pass because I remove the 4 of a kind",expected,actual);
    }
    @Test
    public void printPlayerHandTest(){
        playerHand.add(aceTest);
        playerHand.add(kingTest);
        playerHand.add(queenTest);
        System.out.println(goFish.displayCard(playerHand));
        String expected = "A K Q ";
        String actual = goFish.displayCard(playerHand);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void checkCardTest(){
        playerHand.add(aceTest);
        playerHand.add(kingTest);
        playerHand.add(aceTest);
        dealerHand.add(aceTest);
        dealerHand.add(kingTest);
        boolean expected = true;
        boolean actual = goFish.requestedCardIsInPlayersHand(playerHand, aceTest);
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void takeCardTest(){
        playerHand.add(kingTest);
        playerHand.add(aceTest);
        playerHand.add(aceTest);
        dealerHand.add(aceTest);
        dealerHand.add(kingTest);
        goFish.takeCard(dealerHand, playerHand, aceTest);
        int expected = 4;
        int actual = playerHand.size();
        System.out.println(goFish.displayCard(dealerHand));
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void lookThroughWholeHandAndTakeCardTest(){
        playerHand.add(aceTest);
        playerHand.add(kingTest);
        playerHand.add(aceTest);
        dealerHand.add(aceTest);
        goFish.lookThroughWholeHandAndTakeCards(playerHand, dealerHand, aceTest);
        int expected = 3;
        int actual = dealerHand.size();
        System.out.println(goFish.displayCard(playerHand));
        System.out.println(goFish.displayCard(dealerHand));
        Assert.assertEquals("dealer should take 3 aces from player",expected, actual);

    }



}
