package org.program.stones;

import org.program.preciousstonemanager.database.DatabaseWorker;

import java.util.List;

public class Storage {
    public static List<Stone> collection;
    public static List<Stone> necklace;

    public static void initializeStorage() {
        collection = DatabaseWorker.readFromDatabase(false);
        necklace = DatabaseWorker.readFromDatabase(true);
    }
}
