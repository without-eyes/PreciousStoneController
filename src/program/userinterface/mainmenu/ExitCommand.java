package program.userinterface.mainmenu;

import org.apache.log4j.Logger;
import program.execution.FileWorker;
import program.userinterface.interfaceClass.Command;
import program.userinterface.menuinterface.BeautifulOutput;

public class ExitCommand implements Command {
    private static final Logger logger = Logger.getLogger(FileWorker.class);

    public ExitCommand() {
    }

    @Override
    public void execute() {
        logger.info("Завершення роботи програми");
        BeautifulOutput.printYellow("\n================================================================================================\n");
        BeautifulOutput.printRed("\t\t\t\t\t\t\t*** Завершення роботи програми! ***");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Завершити роботу програми";
    }
}
