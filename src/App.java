
public class App {

    public static void main(String[] args) throws Exception {
        IO.println("Let's play blackjack!");

        // Get a new deck
        Deck deck = new Deck();
        deck.Shuffle();

        // Give the player 2 cards
        Hand PlayerHand = new Hand();
        Hand DealerHand = new Hand();

        DealerHand.GiveCard(deck.GetCard());
        PlayerHand.GiveCard(deck.GetCard());
        DealerHand.GiveCard(deck.GetCard());
        PlayerHand.GiveCard(deck.GetCard());

        String winner = null;
        boolean stand = false;

        while (winner == null) {
            IO.println("- - - - - - - - - - - - - - - - - - - - -\n");

            // Show the cards
            IO.println("Your cards:");
            PlayerHand.ShowCards(false);

            IO.println("Dealer's cards:");
            DealerHand.ShowCards(true);

            // Make sure the dealer has a sum >= 17
            // Check for a winner
            winner = CheckForWinner(DealerHand, PlayerHand, stand);

            if (winner == null) {
                if (DealerHand.GetSum() < 17) {
                    DealerHand.GiveCard(deck.GetCard());
                }

                // There is no winner so then we need to choose to hit or stand.
                String choice = IO.readln("Would you like to stand?\n   Type 'stand' or 'y' to stand\n   : ");

                if ("stand".equals(choice) || "y".equals(choice)) {
                    stand = true;
                } else {
                    PlayerHand.GiveCard(deck.GetCard());
                }
            }
        }

        IO.println("- - - - - - - - GAME END - - - - - - - -");
        IO.println();
        IO.println(winner + " wins!");
        IO.println();

        IO.println("You had:");
        PlayerHand.ShowCards(false);

        IO.println("Dealer had:");
        DealerHand.ShowCards(false);
    }

    public static String CheckForWinner(Hand dealerHand, Hand plrHand, boolean stand) {
        String winner = null;

        int plrSum = plrHand.GetSum();
        int dealerSum = dealerHand.GetSum();

        if (plrSum > 21) {
            winner = "Dealer";
        } else if (dealerSum > 21) {
            winner = "Player";
        } else if (dealerSum == 21) {
            winner = "Dealer";
        } else if (plrSum == 21) {
            winner = "Player";
        }

        if (stand == true) {
            if (plrSum > dealerSum) {
                winner = "Player";
            } else {
                winner = "Dealer";
            }
        }

        return winner;
    }
}
