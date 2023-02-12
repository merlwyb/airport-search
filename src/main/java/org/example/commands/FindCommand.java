package org.example.commands;

import org.example.utils.DataController;

public class FindCommand extends AbstractCommand {

    public FindCommand(String line) {
        super(line);
    }

    @Override
    public void execute(DataController dataController) {
        dataController.printByColumnAndLine(this.getArg());
    }
}
