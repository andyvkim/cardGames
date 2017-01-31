package Kim.Andy.CardGames;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by andykim on 1/27/17.
 */
public abstract class CardGames {


    protected Deck deckOfCards = new Deck();

    protected ArrayList<Card> playerHand = new ArrayList<Card>();

    protected ArrayList<Card> dealerHand = new ArrayList<Card>();

    public abstract void dealCards();

}
