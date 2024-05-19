package org.program.userinterface.submenu;

import org.apache.log4j.Logger;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.stones.Stone;
import org.program.userinterface.interfaceClass.Command;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.program.userinterface.menuinterface.BeautifulOutput.*;

public class DeleteStoneFromNecklaceCommand implements Command {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);
    private final List<Stone> necklace;
    private final List<Stone> collection;

    /**
     * @param collection
     * @param necklace
     */
    public DeleteStoneFromNecklaceCommand(List<Stone> collection, List<Stone> necklace) {
        this.collection = collection;
        this.necklace = necklace;
    }

    /**
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        printYellow("\n================================================================================================");
        printPurple("\nСписок каменів:");
        int index = 1;
        for (Stone stone : necklace) {
            System.out.println((index++) + ") " + stone.getAsString());
        }
        Scanner scanner = new Scanner(System.in);
        printGreen("\nВиберіть камінь для видалення з намиста: ");
        int stoneIndex = scanner.nextInt();

        logger.info("Видалення каменя \"" + necklace.get(stoneIndex - 1).getName() + "\" з намиста");

        printRed("\nВидалений камінь: " + necklace.get(stoneIndex - 1).getAsString());

//        DatabaseWorker.deleteStone(necklace.get(stoneIndex - 1), "necklace");
//        DatabaseWorker.writeIntoDatabase(necklace.get(stoneIndex - 1), "collection");

        collection.add(necklace.get(stoneIndex - 1));
        necklace.remove(stoneIndex - 1);
    }

    @Override
    public String getDescription() {
        return "Видалити камінь з намиста";
    }
}
