package org.program.preciousstonemanager.models;

import org.program.preciousstonemanager.database.DatabaseWorker;

import java.util.List;

public class Storage {
    private static List<Stone> collection;
    private static List<Stone> necklace;

    public static void initializeStorage() {
        collection = DatabaseWorker.readFromDatabase(false);
        necklace = DatabaseWorker.readFromDatabase(true);
    }

    public static List<Stone> getCollection() {
        return collection;
    }

    public static void setCollection(List<Stone> newCollection) {
        collection = newCollection;
    }

    public static List<Stone> getNecklace() {
        return necklace;
    }

    public static void setNecklace(List<Stone> newNecklace) {
        necklace = newNecklace;
    }

    public static void addIntoCollection(Stone stone) {
        collection.add(stone);
        DatabaseWorker.writeIntoDatabase(stone, false);
    }

    public static void deleteFromCollection(Stone stone) {
        collection.remove(stone);
        DatabaseWorker.deleteStone(stone);
    }

    /**
     * @param stone
     * @param swapToNecklace
     */
    public static void changeStoneStorage(Stone stone, Boolean swapToNecklace) {
        DatabaseWorker.changeStoneStorage(stone);
        if (swapToNecklace) {
            Storage.collection.remove(stone);
            stone.setIsInNecklace(true);
            Storage.necklace.add(stone);
        } else {
            Storage.necklace.remove(stone);
            stone.setIsInNecklace(false);
            Storage.collection.add(stone);
        }
    }
}
