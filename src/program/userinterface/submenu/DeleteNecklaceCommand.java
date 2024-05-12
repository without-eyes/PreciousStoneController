package program.userinterface.submenu;

import org.apache.log4j.Logger;
import program.execution.FileWorker;
import program.userinterface.interfaceClass.Command;
import program.stones.Stone;

import java.util.List;

public class DeleteNecklaceCommand implements Command {
    private static final Logger logger = Logger.getLogger(FileWorker.class);
    private final List<Stone> necklace;

    public DeleteNecklaceCommand(List<Stone> necklace) {
        this.necklace = necklace;
    }

    @Override
    public void execute() {
        logger.info("Видалення намиста");
        necklace.clear();
        FileWorker.cleanFolder("necklace");
    }

    @Override
    public String getDescription() {
        return "Видалення намиста";
    }
}
