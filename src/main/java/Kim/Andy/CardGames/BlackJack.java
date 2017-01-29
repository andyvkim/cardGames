package Kim.Andy.CardGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class BlackJack extends CardGames {

    int winCount;


    public ArrayList<Card> playerHand = new ArrayList<Card>();

    public ArrayList<Card> dealerHand = new ArrayList<Card>();

    String printedPlayerHand;

    String printedDealerHand;

    public String getPrintedPlayerHand(){
        return this.printedPlayerHand;
    }
    public String getPrintedDealerHand(){
        return this.printedDealerHand;
    }
    public void setPrintedPlayerHand(String printedPlayerHand){
        this.printedPlayerHand = printedPlayerHand;
    }
    public void setPrintedDealerHand(String printedDealerHand){
        this.printedDealerHand = printedDealerHand;
    }


    public void dealCards() {
        for (int i = 0; i < 2; i++) {
            deckOfCards.drawCard(playerHand);
            deckOfCards.drawCard(dealerHand);
        }

    }
    public int determineCardValue(Card card){
        char rank = card.getRank();
        if (rank == 'A')
            return 11;
        else if(rank == 'K' || rank == 'Q' || rank == 'J' || rank == 'T')
            return 10;

        else return rank - 48;
    }
    public int determineHandValue(ArrayList<Card> player){
        int sum = 0;
        for (Card card : player){
            sum += determineCardValue(card);
        }
        return aceRules(player, sum);
    }
    private int aceRules(ArrayList<Card> player, int sum){
        int counter = 0;
        for(Card card: player){
            if (card.getRank() == 'A'){
                counter++;
            }
        }
        while(counter > 0 && sum > 21){
            sum -= 10;
            counter--;
        }

        return sum;
    }
    public boolean doesDealerHit(ArrayList<Card> dealerHand){
        return (!isHandBusts(playerHand) && determineHandValue(dealerHand) < 17);

    }
    protected boolean isHandBusts(ArrayList<Card> player){
        return (determineHandValue(player) > 21);
    }

    public boolean doesPlayerHit(String response){
        return (response.equals("hit"));


    }
    public void playerHits(ArrayList<Card> player, boolean checker){
        if(checker){
            deckOfCards.drawCard(player);
        }
    }

    public boolean didPlayerWin(ArrayList<Card> dealerHand, ArrayList<Card> playerHand){

        if (isHandBusts(playerHand)){
            System.out.println("You lose!");
            return false;


        }
        else if(isHandBusts(dealerHand) || determineHandValue(playerHand) > determineHandValue(dealerHand)){
            System.out.println("You win!");
            return true;


        } else
            System.out.println("You lose!");
            return false;
    }

    public String printHand(ArrayList<Card> playerHand){
        String printedHand = "";
        for(Card card : playerHand){
            printedHand += card.getRank() + " ";

        }
        return printedHand;
    }




    }











