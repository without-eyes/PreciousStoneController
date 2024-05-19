package org.program.userinterface.submenu;

import org.apache.log4j.Logger;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.preciousstonemanager.stones.Stone;
import org.program.userinterface.interfaceClass.Command;
import org.program.userinterface.menuinterface.BeautifulOutput;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PickStoneFromCollectionCommand implements Command {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);
    private final List<Stone> collection;
    private final List<Stone> necklace;

    /**
     * @param collection
     * @param necklace
     */
    public PickStoneFromCollectionCommand(List<Stone> collection, List<Stone> necklace) {
        this.collection = collection;
        this.necklace = necklace;
    }

    /**
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        BeautifulOutput.printYellow("\n================================================================================================");
        BeautifulOutput.printPurple("\nСписок каменів:");
        if (collection.isEmpty()) {
            BeautifulOutput.printRed("Немає каменів у колекції.");
            return;
        }

        int index = 1;
        for (Stone stone : collection) {
            System.out.println((index++) + ") " + stone.getAsString());
        }
        Scanner scanner = new Scanner(System.in);
        BeautifulOutput.printGreen("\nВиберіть камінь для додавання у намисто: ");
        int stoneIndex = scanner.nextInt();

        logger.info("Додавання каменя \"" + collection.get(stoneIndex - 1).getName() + "\" до намиста");

//        DatabaseWorker.deleteStone(collection.get(stoneIndex - 1), "collection");
//        DatabaseWorker.writeIntoDatabase(collection.get(stoneIndex - 1), "necklace");

        necklace.add(collection.get(stoneIndex - 1));
        collection.remove(stoneIndex - 1);
    }

    @Override
    public String getDescription() {
        return "Вибрати камінь";
    }
}
