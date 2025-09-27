import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Deck {
    public static String[] Suits = {"Spades", "Diamonds", "Clubs", "Hearts"};
    public static String[] CardNames = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    public static final HashMap<String, Integer> CardValues = new HashMap<>();
    public static String seperator = " of ";

    static {
        CardValues.put("Ace", 11);
        CardValues.put("King", 10);
        CardValues.put("Queen", 10);
        CardValues.put("Jack", 10);
    }

    private Stack<String> CardDeck = new Stack<>();

    Deck() {
        // make a new deck
        for (String currentSuit : Suits) {
            for (String currentValue : CardNames) {
                String CardName = currentValue + " of " + currentSuit;
                CardDeck.push(CardName);
                //IO.println(CardName);
            }
        }
    }

    public String GetCard() {
        String cardName;

        cardName = (String) CardDeck.pop();

        return cardName;
    }

    public void Shuffle() {
        List<String> cardList = new ArrayList<>(CardDeck);
        Collections.shuffle(cardList);

        Stack<String> newStack = new Stack<>();

        for (int i = 0; i < cardList.size(); i++) {
            newStack.push(cardList.get(i));
        }

        CardDeck = newStack;
    }

    public static int GetCardValue(String cardName) {
        String cardValueString = Deck.GetCardValueName(cardName);

        int cardValue;

        try {
            cardValue = Integer.parseInt(cardValueString);
        } catch (NumberFormatException e) {
            cardValue = CardValues.get(cardValueString);
        }

        return cardValue;
    }

    public static String GetCardValueName(String cardName) {
        String[] cardDetails = cardName.split(seperator);
        String cardValueString = cardDetails[0];

        // IO.println(cardValueString);

        return cardValueString;
    }
}
