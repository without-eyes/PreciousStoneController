package program.execution;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import program.userinterface.interfaceClass.Command;
import program.userinterface.mainmenu.AddStoneCommand;
import program.userinterface.mainmenu.ExitCommand;
import program.userinterface.mainmenu.ShowCollectionCommand;
import program.userinterface.mainmenu.ShowNecklaceCommand;
import program.userinterface.menuinterface.MainMenu;
import program.stones.Stone;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static final Logger logger = Logger.getLogger(FileWorker.class);

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure("src/resources/log4j.properties");

        logger.info("Початок роботи програми");

        List<Stone> collection = FileWorker.readFromFile("collection");
        List<Stone> necklace = FileWorker.readFromFile("necklace");

        Program program = new Program();

        Map<String, Command> commandMap = new LinkedHashMap<>();
        commandMap.put("add", new AddStoneCommand(program, collection));
        commandMap.put("show collection", new ShowCollectionCommand(program, collection));
        commandMap.put("show necklace", new ShowNecklaceCommand(program, collection, necklace));
        commandMap.put("exit", new ExitCommand());

        MainMenu mainMenu = new MainMenu(commandMap);

        while (true) {
            mainMenu.show();
            Command currentCommand = mainMenu.execute();
            currentCommand.execute();
        }
    }
}