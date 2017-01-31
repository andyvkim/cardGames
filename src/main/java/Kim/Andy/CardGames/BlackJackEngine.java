package Kim.Andy.CardGames;

import java.util.Scanner;

/**
 * Created by andykim on 1/29/17.
 */
public class BlackJackEngine extends BlackJack {

    String response;

    public void runBlackJack() {
        dealCards();
        setPrintedPlayerHand(printHand(playerHand));
        determineHandValue(playerHand);
        setPrintedDealerHand(printHand(dealerHand));
        determineHandValue(dealerHand);
        System.out.println("You have " + getPrintedPlayerHand());
        System.out.println("The dealer has " + getPrintedDealerHand());
        Scanner input = new Scanner(System.in);
        System.out.println("Do you hit or stay?");
        do {
            response = input.nextLine();
            if (response.equals("hit")) {
                playerHits(playerHand);
                determineHandValue(playerHand);
                setPrintedPlayerHand(printHand(playerHand));
            }

            System.out.println("You have " + getPrintedPlayerHand());
        } while (!response.equals("stay"));


        System.out.println("Dealer's turn");
        while (doesDealerHit(dealerHand)) {

            playerHits(dealerHand);
            determineHandValue(dealerHand);
            setPrintedDealerHand(printHand(dealerHand));
            System.out.println("The dealer has " + getPrintedDealerHand());
            }
            didPlayerWin(dealerHand, playerHand);



    }
}

