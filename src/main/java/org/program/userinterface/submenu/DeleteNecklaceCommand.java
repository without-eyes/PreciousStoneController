package org.program.userinterface.submenu;

import org.apache.log4j.Logger;
import org.program.execution.DatabaseWorker;
import org.program.stones.Stone;
import org.program.userinterface.interfaceClass.Command;

import java.util.List;

public class DeleteNecklaceCommand implements Command {
    private static final Logger logger = Logger.getLogger(DatabaseWorker.class);
    private final List<Stone> necklace;

    public DeleteNecklaceCommand(List<Stone> necklace) {
        this.necklace = necklace;
    }

    @Override
    public void execute() {
        logger.info("Видалення намиста");
        necklace.clear();
        DatabaseWorker.cleanNecklace("necklace");
    }

    @Override
    public String getDescription() {
        return "Видалення намиста";
    }
}
