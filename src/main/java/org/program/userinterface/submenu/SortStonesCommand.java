package org.program.userinterface.submenu;

import org.apache.log4j.Logger;
import org.program.execution.DatabaseWorker;
import org.program.stones.Stone;
import org.program.userinterface.interfaceClass.Command;
import org.program.userinterface.menuinterface.BeautifulOutput;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SortStonesCommand implements Command {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);
    private final List<Stone> storage;

    /**
     * @param storage
     */
    public SortStonesCommand(List<Stone> storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        BeautifulOutput.printYellow("\n================================================================================================");

        String characteristic;

        while (true) {
            String[] menu = menu();

            BeautifulOutput.printGreen("\nВибір: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            characteristic = choice;

            Collator collator = Collator.getInstance(Locale.US);

            if (choice.equals(menu[1])) {
                storage.sort(Comparator.comparing(Stone::getName, collator));
                break;
            } else if (choice.equals(menu[2])) {
                storage.sort(Comparator.comparing(Stone::getType, collator));
                break;
            } else if (choice.equals(menu[3])) {
                storage.sort(Comparator.comparing(Stone::getColor, collator));
                break;
            } else if (choice.equals(menu[4])) {
                storage.sort(Comparator.comparingInt(Stone::getWeight));
                break;
            } else if (choice.equals(menu[5])) {
                storage.sort(Comparator.comparingInt(Stone::getValue));
                break;
            } else if (choice.equals(menu[6])) {
                storage.sort(Comparator.comparingInt(Stone::getTransparency));
                break;
            } else if (choice.equals(menu[7])) {
                return;
            } else {
                logger.info("Введений параметр, якого немає у списку: " + choice);
                BeautifulOutput.printRed("Помилка! Ви ввели параметр, якого немає у списку!");
            }
        }

        logger.info("Сортування масиву каменів за параметром \"" + characteristic + "\"");
        BeautifulOutput.printPurple("\nМасив, посортований за параметром \"" + characteristic + "\": ");
        int index = 1;
        for (Stone stone : storage) {
            System.out.println((index++) + ") " + stone.getAsString());
        }
    }

    @Override
    public String getDescription() {
        return "Посортувати камені";
    }

    private String[] menu() {
        String[] menu = {"\nЗа яким параметром ви хочете сортувати: ",
                "name",
                "type",
                "color",
                "weight",
                "value",
                "transparency",
                "go back"};

        for (int i = 0; i < menu.length; i++) {
            if (i == 0) {
                BeautifulOutput.printPurple(menu[i]);
            } else {
                System.out.print(i + ") ");
                BeautifulOutput.printBlue(menu[i] + '\n');
            }
        }

        return menu;
    }
}
