package Kim.Andy.CardGames;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public ArrayList<Card> deck = new ArrayList<Card>();

    {
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('A'));
        }

        for(int i = 0; i < 4; i++) {
            deck.add(new Card('K'));
        }

        for(int i = 0; i < 4; i++) {
            deck.add(new Card('Q'));
        }

        for(int i = 0; i < 4; i++) {
            deck.add(new Card('J'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('T'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('9'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('8'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('7'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('6'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('5'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('4'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('3'));

        }
        for(int i = 0; i < 4; i++) {
            deck.add(new Card('2'));

        }
        Collections.shuffle(deck);

    }





    public void drawCard(ArrayList<Card> player){
        Card drawnCard = deck.get(0);
        player.add(drawnCard);
        deck.remove(0);
    }




}






