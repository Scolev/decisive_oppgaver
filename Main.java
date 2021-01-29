package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Blackjack\ntype [play] to play");

            start:while (in.hasNext()) {
                String s = in.nextLine();
                System.out.println("Performing setup");
                Player dealer = new Player();
                Player user = new Player();
                Deck deck = new Deck();

                deck.shuffleDeck();
                dealer.drawCard(deck);
                dealer.drawCard(deck);
                user.drawCard(deck);
                user.drawCard(deck);

                System.out.println("Your cards:");
                user.printCards();
                System.out.println("\n");

                System.out.println("Dealer's cards");
                System.out.println(dealer.hand.getCards().get(0).toString());
                System.out.println("And one hidden card");

                while(true) {
                    if (user.hand.getHandValue() == 21) {
                        System.out.println("Congratulations, you have Blackjack!");
                        System.out.println("Play again? [Yes] or [No]");
                        s = in.nextLine();
                        if (s.equalsIgnoreCase("yes")) {
                            break;
                        } else if (s.equalsIgnoreCase("no")) {
                            break start;
                        } else {
                            System.out.println("invalid response");
                            break;
                        }
                    }
                    while (user.hand.getHandValue() < 21) {
                        System.out.println("[Hit] or [Stay]");
                        s = in.nextLine();
                        if (s.equalsIgnoreCase("hit")) {
                            user.drawCard(deck);
                            user.printCards();
                        } else if (s.equalsIgnoreCase("stay")) {
                            break;
                        }
                    }
                    if (user.hand.getHandValue() == 21) {
                        System.out.println("You have Blackjack!");
//                        break;
                    } else if (user.hand.getHandValue() < 21) {
                        System.out.println("You have chosen to stay\nYour current hand is");
                        user.printCards();
                    } else {
                        System.out.println("Bust! You lose, better luck next time!");
                        System.out.println("Enter [play] to play again");
                        break;
                    }
                    System.out.println("Dealer flips second card");
                    dealer.printCards();
//                    System.out.println("Dealer will now draw");
                    while (dealer.hand.getHandValue() < 16) {
                        System.out.println("Dealer draws");
                        dealer.drawCard(deck);
                        dealer.printCards();
                    }
                    if (dealer.hand.getHandValue() > 21) {
                        System.out.println("Dealer busts, you win!");
                        break;
                    }
                    if (dealer.hand.getHandValue() < user.hand.getHandValue()) {
                        System.out.println("Your hand value " + user.hand.getHandValue());
                        System.out.println("Dealers hand value " + dealer.hand.getHandValue());
                        System.out.println("Congratulations, you win!");
                    } else {
                        System.out.println("Your hand value " + user.hand.getHandValue());
                        System.out.println("Dealers hand value " + dealer.hand.getHandValue());
                        System.out.println("Sorry, you lose");
                    }
                    System.out.println("Play again? [Yes] or [No]");
                    s = in.nextLine();
                    if (s.equalsIgnoreCase("yes")) {
                        break;
                    } else if (s.equalsIgnoreCase("no")) {
                        break start;
                    }
                }
                if (s.equals("exit")) {
                    break;
                }
            }
//        }
    }
}
