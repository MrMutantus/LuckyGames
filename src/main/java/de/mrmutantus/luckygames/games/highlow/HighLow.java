package de.mrmutantus.luckygames.games.highlow;

import de.mrmutantus.luckygames.Game;
import de.mrmutantus.luckygames.card.Card;
import de.mrmutantus.luckygames.card.CardSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class HighLow implements Game {
    Logger LOG = LoggerFactory.getLogger(HighLow.class);
    private final CardSet cardset;
    Scanner scanner;
    String input;
    private Card actualCard;
    private Card lastCard;
    boolean win;

    public HighLow() {
        LOG.info("Initialize HighLow Game...");
        this.scanner = new Scanner(System.in);
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
        System.out.println("Geben sie ihre Wette ab.\nIst die kommende Karte (gr)ößer, (kl)einer oder (gl)eich groß?");
    }

    private String getUserInput() {
        return scanner.next();
    }
}
