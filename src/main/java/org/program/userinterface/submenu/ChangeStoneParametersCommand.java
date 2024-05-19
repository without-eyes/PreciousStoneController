package org.program.userinterface.submenu;

import org.apache.log4j.Logger;
import org.program.preciousstonemanager.database.DatabaseWorker;
import org.program.preciousstonemanager.stones.PreciousStone;
import org.program.preciousstonemanager.stones.SemiPreciousStone;
import org.program.preciousstonemanager.stones.Stone;
import org.program.userinterface.interfaceClass.Command;
import org.program.userinterface.menuinterface.BeautifulOutput;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ChangeStoneParametersCommand implements Command {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);
    private final List<Stone> collection;

    public ChangeStoneParametersCommand(List<Stone> collection) {
        this.collection = collection;
    }

    @Override
    public void execute() throws IOException {

        printCollection();

        Scanner scanner = new Scanner(System.in);
        BeautifulOutput.printGreen("\nВиберіть камінь для зміни його параметрів: ");
        int stoneIndex = scanner.nextInt() - 1;

        logger.info("Зміна параметрів каменя \"" + collection.get(stoneIndex).getName() + "\"");

        while (true) {
            String[] menu = menu();

            BeautifulOutput.printGreen("\nВибір: ");
            scanner.nextLine();
            String choice = scanner.nextLine();

            if (choice.equals(menu[1])) {
                newName(scanner, stoneIndex);
                break;
            } else if (choice.equals(menu[2])) {
                newType(scanner, stoneIndex);
                break;
            } else if (choice.equals(menu[3])) {
                newColor(scanner, stoneIndex);
                break;
            } else if (choice.equals(menu[4])) {
                newWeight(scanner, stoneIndex);
                break;
            } else if (choice.equals(menu[5])) {
                newValue(scanner, stoneIndex);
                break;
            } else if (choice.equals(menu[6])) {
                newTransparency(scanner, stoneIndex);
                break;
            } else if (choice.equals(menu[7])) {
                return;
            } else {
                logger.error("Введений параметр, якого немає у списку: " + choice);
                BeautifulOutput.printRed("Помилка! Такого варіанту немає у виборі!");
            }
        }

//        DatabaseWorker.deleteStone(collection.get(stoneIndex), "collection");
//        DatabaseWorker.writeIntoDatabase(collection.get(stoneIndex), "collection");
    }

    @Override
    public String getDescription() {
        return "Змінити параметри каменя";
    }

    private void printCollection() {
        BeautifulOutput.printYellow("\n================================================================================================");

        BeautifulOutput.printPurple("\nСписок каменів:");
        int index = 1;
        for (Stone stone : collection) {
            System.out.println((index++) + ") " + stone.getAsString());
        }
    }

    public String[] menu() {
        String[] menu = {"\nЯкий параметр ви хочете змінити: ",
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

    public void newName(Scanner scanner, int stoneIndex) {
        BeautifulOutput.printGreen("\nНова назва: ");
        String name = scanner.nextLine();
        collection.get(stoneIndex).setName(name);
    }

    public void newType(Scanner scanner, int stoneIndex) {
        BeautifulOutput.printGreen("\nНовий тип: ");
        String type = scanner.nextLine();
        if (type.equals("дорогоцінний")) {
            collection.add(new PreciousStone(collection.get(stoneIndex).getName(),
                    collection.get(stoneIndex).getColor(),
                    collection.get(stoneIndex).getWeight(),
                    collection.get(stoneIndex).getValue(),
                    collection.get(stoneIndex).getTransparency(),
                    collection.get(stoneIndex).getIsInNecklace()));
            collection.remove(stoneIndex);
        } else if (type.equals("напівкоштовний")) {
            collection.add(new SemiPreciousStone(collection.get(stoneIndex).getName(),
                    collection.get(stoneIndex).getColor(),
                    collection.get(stoneIndex).getWeight(),
                    collection.get(stoneIndex).getValue(),
                    collection.get(stoneIndex).getTransparency(),
                    collection.get(stoneIndex).getIsInNecklace()));
            collection.remove(stoneIndex);
        }
    }

    public void newColor(Scanner scanner, int stoneIndex) {
        BeautifulOutput.printGreen("\nНовий колір: ");
        String color = scanner.nextLine();
        collection.get(stoneIndex).setColor(color);
    }

    public void newWeight(Scanner scanner, int stoneIndex) {
        BeautifulOutput.printGreen("\nНова маса: ");
        int weight = scanner.nextInt();
        collection.get(stoneIndex).setWeight(weight);
    }

    public void newValue(Scanner scanner, int stoneIndex) {
        BeautifulOutput.printGreen("\nНова вартість: ");
        int value = scanner.nextInt();
        collection.get(stoneIndex).setValue(value);
    }

    public void newTransparency(Scanner scanner, int stoneIndex) {
        BeautifulOutput.printGreen("\nНова прозорість: ");
        int transparency = scanner.nextInt();
        collection.get(stoneIndex).setTransparency(transparency);
    }
}