package de.mrmutantus.luckygames.card;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class CardSet {
    List<Card> cards;
    Random rng = new Random();

    public CardSet(int numbers, int colours) {
        cards = CardFactory.createCards(numbers, colours);
    }

    public Card drawCard() {
        int size = cards.size();
        int index = rng.nextInt(size);
        return cards.remove(index);
    }

    public void shuffle() {
        List<Card> newCards = new ArrayList<>();
        int deckSize = cards.size();
        for (int i = 0; i < deckSize; i++) {
            Card newCard = this.drawCard();
            newCards.add(newCard);
        }
        cards = newCards;
    }
}
