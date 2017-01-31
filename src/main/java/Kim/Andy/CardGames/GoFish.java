package Kim.Andy.CardGames;

import java.util.ArrayList;

import java.util.Random;

import java.util.Scanner;

public class GoFish extends CardGames {

    int playerScore = 0;

    Deck deck = new Deck();


    public void dealCards() {
        for (int i = 0; i < 8; i++) {
            deckOfCards.drawCard(playerHand);
            deckOfCards.drawCard(dealerHand);
        }
    }

    public boolean fourOfAKind(ArrayList<Card> hand, Card cardWanted) {
        int counter = 0;
        for (Card card : hand) {
            if (card.getRank() == cardWanted.getRank()) {
                counter += 1;

            }
        }
        return (counter == 4);
    }


    public void removeCardsFromPlay(ArrayList<Card> hand, Card cardWanted, int playerScore) {
        if (fourOfAKind(hand, cardWanted)) {
            hand.remove(cardWanted);
            hand.remove(cardWanted);
            hand.remove(cardWanted);
            hand.remove(cardWanted);
            playerScore++;
        }

    }

    public String displayCard(ArrayList<Card> hand) {
        String printedPlayerHand = "";
        for (Card card : hand) {
            printedPlayerHand += card.getRank() + " ";
        }
        return printedPlayerHand;
    }

    public boolean requestedCardIsInPlayersHand(ArrayList<Card> playerHand, Card requestedCard) {
        for (Card playerCard : playerHand) {
            if (playerCard.getRank() == requestedCard.getRank()) {
                return true;
            }
            else deckOfCards.drawCard(playerHand);
        }
        return false;
    }

    public void takeCard(ArrayList<Card> opposingHand, ArrayList<Card> playerHand, Card requestedCard) {
        if (requestedCardIsInPlayersHand(opposingHand, requestedCard)) {
            playerHand.add(requestedCard);
            opposingHand.remove(requestedCard);
            opposingHand.trimToSize();

        }
    }

    public void lookThroughWholeHandAndTakeCards(ArrayList<Card> opposingHand, ArrayList<Card> playerHand, Card requestedCard) {

        for (int i = opposingHand.size() - 1; i >= 0; i++) {
            if (requestedCardIsInPlayersHand(opposingHand, requestedCard)) {
                takeCard(opposingHand, playerHand, requestedCard);
            }
        }
    }

    private Card dealerRequest(ArrayList<Card> dealerHand) {
        Random rand = new Random();
        return dealerHand.get(rand.nextInt(dealerHand.size()));
    }

    public Card inputToCard(String card) {
        switch (card.toUpperCase()) {
            default:
            case "A":
                return new Card('A');
            case "K":
                return new Card('K');
            case "Q":
                return new Card('Q');
            case "J":
                return new Card('J');
            case "10":
            case "T":
                return new Card('T');
            case "9":
                return new Card('9');
            case "8":
                return new Card('8');
            case "7":
                return new Card('7');
            case "6":
                return new Card('6');
            case "5":
                return new Card('5');
            case "4":
                return new Card('4');
            case "3":
                return new Card('3');
            case "2":
                return new Card('2');

        }


    }

    private void drawCardifPlayerHasNoCards(ArrayList<Card> playerHand) {
        if (playerHand.size() == 0) {
            deckOfCards.drawCard(playerHand);
        }
    }

    private String dealerScore(int playerScore) {
        int dealerScore = 13 - playerScore;
        if (dealerScore < playerScore) {
            return "you win";
        } else return "you lose";
    }


    protected void playerTurn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ask for a card");
        String cardRequested = input.nextLine();
        requestedCardIsInPlayersHand(dealerHand, inputToCard(cardRequested));
        lookThroughWholeHandAndTakeCards(dealerHand, playerHand, inputToCard(cardRequested));
        System.out.println("You have " + displayCard(playerHand));
    }
    protected void dealerTurn() {
        requestedCardIsInPlayersHand(playerHand, dealerRequest(dealerHand));
        lookThroughWholeHandAndTakeCards(playerHand, dealerHand, dealerRequest(dealerHand));
        System.out.println("You have " + displayCard(playerHand));
    }
    protected String gameEnd(Deck deck){
        if (deck.equals(0)) {
        return ("Game over");
        }
        return "Game over";
    }
}


