package program.userinterface.menuinterface;

import program.userinterface.interfaceClass.Command;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static program.userinterface.menuinterface.BeautifulOutput.*;

public class MainMenu {
    protected final Map<String, Command> commandMap;

    /**
     * @param commandMap
     */
    public MainMenu(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    /**
     * @return
     * @throws IOException
     */
    public Command execute() {
        printGreen("\nВведіть команду: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (commandMap.containsKey(choice)) {
            return commandMap.get(choice);
        } else {
            throw new IllegalArgumentException("Неправильна команда! Введіть ще раз.");
        }
    }

    public void show() {
        printYellow("\n================================================================================================");
        printPurple("\nГоловне меню:");
        int index = 1;
        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            System.out.print((index++) + ") ");
            printBlue(entry.getKey());
            System.out.println(" (" + entry.getValue().getDescription() + ")");
        }
    }
}
