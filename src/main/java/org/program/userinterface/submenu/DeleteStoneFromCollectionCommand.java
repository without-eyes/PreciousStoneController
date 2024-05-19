package org.program.userinterface.submenu;

import org.apache.log4j.Logger;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.stones.Stone;
import org.program.userinterface.interfaceClass.Command;
import org.program.userinterface.menuinterface.BeautifulOutput;

import java.util.List;
import java.util.Scanner;

public class DeleteStoneFromCollectionCommand implements Command {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);
    private final List<Stone> collection;

    /**
     * @param collection
     */
    public DeleteStoneFromCollectionCommand(List<Stone> collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        BeautifulOutput.printYellow("\n================================================================================================");
        BeautifulOutput.printPurple("\nСписок каменів:");
        int index = 1;
        for (Stone stone : collection) {
            System.out.println((index++) + ") " + stone.getAsString());
        }
        Scanner scanner = new Scanner(System.in);
        BeautifulOutput.printGreen("\nВиберіть камінь для видалення з колекції: ");
        int stoneIndex = scanner.nextInt();

        logger.info("Видалення каміня \"" + collection.get(stoneIndex - 1).getName() + "\" з колекції");

        BeautifulOutput.printRed("\nВидалений камінь: " + collection.get(stoneIndex - 1).getAsString());
        //DatabaseWorker.deleteStone(collection.get(stoneIndex - 1), "collection");

        collection.remove(stoneIndex - 1);
    }

    @Override
    public String getDescription() {
        return "Видалити камінь з колекції";
    }
}
