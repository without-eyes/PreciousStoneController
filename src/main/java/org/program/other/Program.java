package org.program.other;

import org.apache.log4j.Logger;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.stones.PreciousStone;
import org.program.stones.SemiPreciousStone;
import org.program.stones.Stone;
import org.program.userinterface.interfaceClass.Command;
import org.program.userinterface.menuinterface.SubMenu;
import org.program.userinterface.submenu.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.program.userinterface.menuinterface.BeautifulOutput.*;

public class Program {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);

    /**
     * @param collection
     * @throws IOException
     */
    public void addStoneToCollection(List<Stone> collection) throws IOException {
        logger.info("Додавання каменя до колекції");
        printYellow("\n================================================================================================");

        Scanner scanner = new Scanner(System.in);

        printGreen("\nВведіть назву каменя: ");
        String name = scanner.nextLine();

        printGreen("\nВведіть тип(дорогоцінний/напівкоштовний): ");
        String type = scanner.nextLine();

        printGreen("\nВведіть колір: ");
        String color = scanner.nextLine();

        printGreen("\nВведіть масу(в каратах): ");
        int weight = scanner.nextInt();

        printGreen("\nВведіть вартість(в доларах): ");
        int value = scanner.nextInt();

        printGreen("\nВведіть процент прозорості: ");
        int transparency = scanner.nextInt();

        if (type.equals("дорогоцінний")) {
            PreciousStone stone = new PreciousStone(name, color, weight, value, transparency);
            collection.add(stone);
            //DatabaseWorker.writeIntoDatabase(stone, "collection");
        } else if (type.equals("напівкоштовний")) {
            SemiPreciousStone stone = new SemiPreciousStone(name, color, weight, value, transparency);
            collection.add(stone);
            //DatabaseWorker.writeIntoDatabase(stone, "collection");
        }
    }

    /**
     * @param collection
     * @param necklace
     * @throws IOException
     */
    public void showNecklace(List<Stone> collection, List<Stone> necklace) throws IOException {
        logger.info("Вивід на екран намиста");

        printYellow("\n================================================================================================");

        Map<String, Command> commandMapSub = new LinkedHashMap<>();
        if (necklace.isEmpty()) {
            commandMapSub.put("pick", new PickStoneFromCollectionCommand(collection, necklace));
            commandMapSub.put("go back", new GoUpCommand());
        } else {
            commandMapSub.put("pick", new PickStoneFromCollectionCommand(collection, necklace));
            commandMapSub.put("sort", new SortStonesCommand(necklace));
            commandMapSub.put("find", new FindByTransparencyCommand(necklace));
            commandMapSub.put("calculate", new CalculateNecklaceParametersCommand(necklace));
            commandMapSub.put("delete stone", new DeleteStoneFromNecklaceCommand(collection, necklace));
            commandMapSub.put("delete necklace", new DeleteNecklaceCommand(necklace));
            commandMapSub.put("go back", new GoUpCommand());
        }

        printPurple("\nНамисто:");
        printStorage(necklace);

        SubMenu subMenu = new SubMenu(commandMapSub);
        subMenu.show();
        Command currentCommand = subMenu.execute();
        currentCommand.execute();
    }

    /**
     * @param collection
     * @throws IOException
     */
    public void showCollection(List<Stone> collection) throws IOException {
        logger.info("Вивід на екран колекції");

        printYellow("\n================================================================================================");

        Map<String, Command> commandMapSub = new LinkedHashMap<>();
        if (collection.isEmpty()) {
            commandMapSub.put("go back", new GoUpCommand());
        } else {
            commandMapSub.put("sort", new SortStonesCommand(collection));
            commandMapSub.put("find", new FindByTransparencyCommand(collection));
            commandMapSub.put("change", new ChangeStoneParametersCommand(collection));
            commandMapSub.put("delete stone", new DeleteStoneFromCollectionCommand(collection));
            commandMapSub.put("go back", new GoUpCommand());

        }

        printPurple("\nКолекція каменів:");
        printStorage(collection);

        SubMenu subMenu = new SubMenu(commandMapSub);
        subMenu.show();
        Command currentCommand = subMenu.execute();
        currentCommand.execute();
    }

    /**
     * @param storage
     */
    private void printStorage(List<Stone> storage) {
        if (storage.isEmpty()) {
            printRed("Немає каменів!");
        } else {
            int index = 1;
            for (Stone stone : storage) {
                System.out.println((index++) + ") " + stone.getAsString());
            }
        }
    }
}
