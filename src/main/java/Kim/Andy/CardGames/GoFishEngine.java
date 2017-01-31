package Kim.Andy.CardGames;

import java.util.Scanner;

public class GoFishEngine extends GoFish {


    public void runGoFish(){

        dealCards();
        displayCard(playerHand);
        System.out.println("You have " + displayCard(playerHand));

            playerTurn();
            dealerTurn();
        }


    }


