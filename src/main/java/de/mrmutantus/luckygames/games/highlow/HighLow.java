package de.mrmutantus.luckygames.games.highlow;

import de.mrmutantus.luckygames.card.Card;
import de.mrmutantus.luckygames.card.CardSet;
import de.mrmutantus.luckygames.games.Game;
import org.slf4j.Logger;

import java.util.Scanner;

public class HighLow implements Game {
    Logger LOG;
    private final CardSet cardset;
    Scanner scanner;
    String input;
    private Card actualCard;
    private Card lastCard;
    boolean win;

    public HighLow(Logger logger, Scanner scanner) {
        LOG = logger;
        LOG.info("Initialize HighLow Game...");
        this.scanner = scanner;
        this.cardset = new CardSet(10, 4);
        LOG.info("Shuffle cards...");
        cardset.shuffle();
        LOG.info("Drawing first card...");
        actualCard = drawCard();
        LOG.info("Drew " + actualCard);
    }

    @Override
    public void nextRound() {
        lastCard = actualCard;
        displayInstructions();
        input = getUserInput();
        actualCard = drawCard();
        LOG.info(actualCard + " drawn.");
        win = this.getResult();
        announceWin();
        if (cardset.getCards().size() < 10) {
            LOG.info("shuffling cards...");
            cardset.shuffle();
        }
    }

    private void announceWin() {
        if (win) {
            LOG.info("Round won!");
        } else {
            LOG.info("Round lost...");
        }
    }

    private boolean getResult() {
        return switch (input) {
            case "gr" -> actualCard.getNumber() > lastCard.getNumber();
            case "kl" -> actualCard.getNumber() < lastCard.getNumber();
            case "gl" -> actualCard.getNumber() == lastCard.getNumber();
            default -> false;
        };
    }

    private Card drawCard() {
        LOG.info("Draw new card...");
        return cardset.drawCard();
    }

    private void displayInstructions() {
        LOG.info("Geben sie ihre Wette ab.\nIst die kommende Karte (gr)ößer, (kl)einer oder (gl)eich groß?");
    }

    private String getUserInput() {
        return scanner.next();
    }
}
