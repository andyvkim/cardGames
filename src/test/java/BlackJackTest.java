import org.junit.Assert;
import org.junit.Test;
import Kim.Andy.CardGames.*;
import java.util.ArrayList;


public class BlackJackTest {

    BlackJack blackJack = new BlackJack();
    ArrayList<Card> player = new ArrayList<Card>();
    ArrayList<Card> dealer = new ArrayList<Card>();
    Card aceTest = new Card('A');
    Card kingTest = new Card('K');
    Card fiveTest = new Card('5');

    @Test
    public void dealCardsTest(){
        blackJack.dealCards();
        int expected = 2;
        int actual = blackJack.dealerHand.size();
        Assert.assertEquals("I expect the dealer hand size to be 2",expected, actual);
    }

    @Test
    public void testThisCrazyCharMath(){
        Card card = new Card('9');
        int expected = 9;
        int actual = blackJack.determineCardValue(card);
        Assert.assertEquals("I expect the card value to be 9",expected, actual);

    }
    @Test
    public void determineHandValueTest(){
        player.add(aceTest);
        player.add(kingTest);
        int expected = 21;
        int actual = blackJack.determineHandValue(player);
        Assert.assertEquals("I expect the hand value to be 21",expected, actual);

    }
    @Test
    public void aceTest(){
        player.add(aceTest);
        player.add(aceTest);
        int expected = 12;
        int actual = blackJack.determineHandValue(player);
        Assert.assertEquals("I expect the ace values to adjust and prevent a bust.",expected, actual);

    }
    @Test
    public void dealerHitTest(){
        dealer.add(aceTest);
        dealer.add(kingTest);
        player.add(kingTest);
        player.add(kingTest);
        boolean expected = false;
        boolean actual = blackJack.doesDealerHit(dealer);
        Assert.assertEquals("I expect this to pass because dealer should not hit", expected, actual);
    }
    @Test
    public void doesPlayerHitTest(){
        player.add(aceTest);
        int expected = 2;
        blackJack.playerHits(player);
        int actual = player.size();
        Assert.assertEquals("I expect two cards in players hand",expected, actual);
    }
    @Test
    public void dealerHas21PlayerNoBustTest(){
        dealer.add(aceTest);
        dealer.add(kingTest);
        int expected = 2;
        blackJack.playerHits(dealer);
        int actual = dealer.size();
        Assert.assertEquals("I expect two cards in dealers hand",expected, actual);
    }
    @Test
    public void dealerHas15PlayerNoBustTest(){
        dealer.add(fiveTest);
        dealer.add(kingTest);
        int expected = 3;
        blackJack.playerHits(dealer);
        int actual = dealer.size();
        Assert.assertEquals("I expect three cards in dealers hand",expected, actual);
    }
    @Test
    public void dealerHasHandBetween17And20(){
        dealer.add(kingTest);
        dealer.add(kingTest);
        int expected = 2;
        blackJack.playerHits(dealer);
        int actual = dealer.size();
        Assert.assertEquals("I expect dealer to stay because he has value between 17 and 20",expected, actual);
    }
    @Test
    public void didYouWinTest(){
        dealer.add(kingTest);
        dealer.add(kingTest);
        player.add(aceTest);
        player.add(aceTest);
        boolean expected = false;
        boolean actual = blackJack.didPlayerWin(dealer, player);
        Assert.assertEquals("I expect to player to lose",expected, actual);
    }

    @Test
    public void printHandTest(){
        player.add(kingTest);
        player.add(kingTest);
        String expected = "K K ";
        String actual = blackJack.printHand(player);
        Assert.assertEquals("I expect K K to print",expected, actual);
    }





}
