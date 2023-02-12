package org.example.commands;

import org.example.utils.DataController;

public class ExitCommand extends AbstractCommand {
    @Override
    public void execute(DataController dataController) {
        System.out.println("Завершение работы программы...");
    }
}
