package menu;

import game.Game;

import java.util.Scanner;

public class Menu {
    private Game chess;

    public Menu() {
        chess = new Game();

    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome:" + "\n" + "PLAY" + "\n" + "EXIT");

        String userInput = scanner.nextLine().toUpperCase();
        MenuType choice = MenuType.valueOf(userInput);

        switch (choice) {
            case PLAY -> chess.start();
            case EXIT -> System.exit(0);
        }
    }


}


