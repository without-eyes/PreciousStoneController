package org.program.userinterface.submenu;

import org.apache.log4j.Logger;
import org.program.execution.DatabaseWorker;
import org.program.stones.Stone;
import org.program.userinterface.interfaceClass.Command;
import org.program.userinterface.menuinterface.BeautifulOutput;

import java.util.List;

public class CalculateNecklaceParametersCommand implements Command {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);
    private final List<Stone> necklace;

    public CalculateNecklaceParametersCommand(List<Stone> necklace) {
        this.necklace = necklace;
    }

    @Override
    public void execute() {
        logger.info("Розрахування вартості і ваги намиста");

        BeautifulOutput.printYellow("\n================================================================================================");
        int necklaceValue = 0;
        int necklaceWeight = 0;
        for (Stone stone : necklace) {
            necklaceValue += stone.getValue();
            necklaceWeight += stone.getWeight();
        }

        BeautifulOutput.printPurple("\nХарактеристика намиста:");
        System.out.println("> Вартість: " + necklaceValue);
        System.out.println("> Маса: " + necklaceWeight);
    }

    @Override
    public String getDescription() {
        return "Розрахувати вартість і вагу намиста";
    }
}
