package program.userinterface.mainmenu;

import program.execution.Program;
import program.userinterface.interfaceClass.Command;
import program.stones.Stone;

import java.io.IOException;
import java.util.List;

public class ShowCollectionCommand implements Command {
    private final Program program;
    private final List<Stone> collection;

    /**
     * @param program
     * @param collection
     */
    public ShowCollectionCommand(Program program, List<Stone> collection) {
        this.program = program;
        this.collection = collection;
    }

    /**
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        program.showCollection(collection);
    }

    @Override
    public String getDescription() {
        return "Показати колекцію";
    }
}