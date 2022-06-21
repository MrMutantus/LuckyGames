package de.mrmutantus.luckygames;

import de.mrmutantus.luckygames.games.Game;
import de.mrmutantus.luckygames.games.GameField;
import de.mrmutantus.luckygames.games.highlow.HighLow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LuckyGamesApplication implements CommandLineRunner {
    Logger LOG = LoggerFactory.getLogger(HighLow.class);

    Scanner scanner = new Scanner(System.in);
    GameField gamefield;

    public static void main(String[] args) {
        SpringApplication.run(LuckyGamesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOG.info("ANWENDUNG GESTARTET");
        gamefield = new GameField(LOG, scanner);
        while(gamefield.isRunning()){
            gamefield.run();
        }
        LOG.info("ANWENUNG BEENDET");
    }

}
