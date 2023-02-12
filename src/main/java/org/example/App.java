package org.example;

import org.example.utils.ConsoleListener;
import org.example.utils.DataController;


public class App {
    public static void main(String[] args) {
        ConsoleListener consoleListener = new ConsoleListener();

        DataController dataController = new DataController();

        if(!args[0].matches("([1-9]|1[0-4])"))
            throw new RuntimeException("Нет колонки с таким номером");
        dataController.setColumnNum(Integer.parseInt(args[0])-1);

        //dataController.setColumnNum(2-1);

        consoleListener.listen(dataController);

        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedBytes / 1048576);
    }
}