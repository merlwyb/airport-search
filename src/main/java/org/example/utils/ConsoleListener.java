package org.example.utils;

import org.example.commands.AbstractCommand;
import org.example.commands.ExitCommand;
import org.example.commands.FindCommand;

import java.util.Scanner;

public class ConsoleListener {
    private static final Scanner SCANNER = new Scanner(System.in);
    private boolean isRunning;

    public ConsoleListener() {
        this.isRunning = true;
    }

    public void listen(DataController dataController) {
        while (isRunning) {
            AbstractCommand command = readLine();
            command.execute(dataController);
        }
    }

    private AbstractCommand readLine() {
        System.out.println("Введите строку: ");
        String line = SCANNER.nextLine().toLowerCase().trim();
        switch (line) {
            case "!quit":
                isRunning = false;
                return new ExitCommand();
            default:
                return new FindCommand(line);
        }
    }
}
