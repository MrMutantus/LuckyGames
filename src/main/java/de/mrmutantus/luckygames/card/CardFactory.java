package de.mrmutantus.luckygames.card;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    public static List<Card> createCards(int numbers, int colors){
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < numbers; i++){
            for (int j = 0; j < colors; j++) {
                Card card = new Card(i, "Farbe " + j);
                cards.add(card);
            }
        }
        return cards;
    }
}
