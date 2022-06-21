package de.mrmutantus.luckygames.games;

import de.mrmutantus.luckygames.games.highlow.HighLow;
import lombok.Getter;
import org.slf4j.Logger;

import java.util.Scanner;

public class GameField {
    Logger logger;
    Scanner input;
    Game game;
    @Getter
    private boolean isRunning;


    public GameField(Logger logger, Scanner input) {
        this.logger = logger;
        this.input = input;
        initializeGamefield();
        isRunning = true;
    }

    public void run() {
        game.nextRound();
        isRunning = askPlayAnotherRound();

    }

    private void initializeGamefield() {
        logger.info("Initialize gamefield...");
        setGameMode();
    }

    private void setGameMode(){
        logger.info("Setting gamemode to high-low");
        game = new HighLow(logger, input);
    }

    private boolean askPlayAnotherRound() {
        logger.info("Noch eine Runde spielen? (Y)es/No");
        String result = input.next();
        return result.equalsIgnoreCase("Yes") || result.equalsIgnoreCase("Y");
    }
}
