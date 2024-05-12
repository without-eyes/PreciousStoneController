package program.userinterface.submenu;

import org.apache.log4j.Logger;
import program.execution.FileWorker;
import program.userinterface.interfaceClass.Command;
import program.userinterface.menuinterface.BeautifulOutput;
import program.stones.Stone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindByTransparencyCommand implements Command {
    private static final Logger logger = Logger.getLogger(FileWorker.class);
    private final List<Stone> storage;

    /**
     * @param storage
     */
    public FindByTransparencyCommand(List<Stone> storage) {
        this.storage = storage;
    }

    @Override
    public void execute() {
        logger.info("Знаходження камені за прозорістю");
        BeautifulOutput.printYellow("\n================================================================================================");

        Scanner scanner = new Scanner(System.in);
        BeautifulOutput.printGreen("Введіть нижню межу прозорості: ");
        int border1 = scanner.nextInt();
        BeautifulOutput.printGreen("Введіть вищу межу прозорості: ");
        int border2 = scanner.nextInt();

        List<Stone> tempStorage = new ArrayList<>();

        for (Stone stone : storage) {
            if (stone.getTransparency() >= border1 && stone.getTransparency() <= border2) {
                tempStorage.add(stone);
            }
        }

        BeautifulOutput.printPurple("\nКамені, які мають прозорість у проміжку від " + border1 + " до " + border2 + ": ");
        int index = 1;
        for (Stone stone : tempStorage) {
            System.out.println(index + ") " + stone.getAsString());
        }
        if (tempStorage.isEmpty()) {
            BeautifulOutput.printRed("Немає таких каменів.");
        }
    }

    @Override
    public String getDescription() {
        return "Знайти камені за прозорістю";
    }
}
