package de.mrmutantus.luckygames.card;

import lombok.Getter;

@Getter
public class Card {
    private final int number;
    private final String color;

    public Card(int number, String color) {
        this.number = number;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Z: " + number + " F: " + color;
    }
}
