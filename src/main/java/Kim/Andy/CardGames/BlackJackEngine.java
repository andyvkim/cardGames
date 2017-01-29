package Kim.Andy.CardGames;

import java.util.Scanner;

/**
 * Created by andykim on 1/29/17.
 */
public class BlackJackEngine extends BlackJack {
        public void runBlackJack() {
                dealCards();
                setPrintedPlayerHand(printHand(playerHand));
                setPrintedDealerHand(printHand(dealerHand));
                System.out.println("You have " + getPrintedPlayerHand());
                System.out.println("The dealer has " + getPrintedDealerHand());
                Scanner input = new Scanner(System.in);
                while (!input.equals("stay")) {
                        boolean checker = true;
                        playerHits(playerHand, checker);
                        System.out.println("Do you hit or stay?");
                        String nextResponse = input.nextLine();
                        if (!nextResponse.equals("hit")) {
                                break;
                        }
                }
                System.out.println("Dealer's turn");
                playerHits(dealerHand, doesDealerHit(dealerHand));
                didPlayerWin(dealerHand, playerHand);
                {
                }
        }
}
