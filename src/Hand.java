import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int Sum = 0;
    private final List<String> Cards = new ArrayList<>();
    private int AceCount = 0;

    public void GiveCard(String cardString) {
        Cards.add(cardString);

        if (Deck.GetCardValueName(cardString).equals("Ace")) {
            AceCount += 1;
        }

        Sum += Deck.GetCardValue(cardString);

        if (Sum > 21) {
            if (AceCount > 0) {
                AceCount -= 1;
                Sum -= 10;
            }
        }
    }

    public int GetSum() {
        return Sum;
    }

    public void ShowCards(boolean hide) {
        for (String thisCard : Cards) {
            if (hide == true) {
                IO.println("??? "+Deck.seperator+ " ???");
            } else {
                IO.println(thisCard);
            }
        }

        IO.println();
    }
}
