package org.program.userinterface.mainmenu;

import org.program.other.Program;
import org.program.stones.Stone;
import org.program.userinterface.interfaceClass.Command;

import java.io.IOException;
import java.util.List;

public class AddStoneCommand implements Command {
    private final Program program;
    private final List<Stone> collection;

    /**
     * @param program
     * @param collection
     */
    public AddStoneCommand(Program program, List<Stone> collection) {
        this.program = program;
        this.collection = collection;
    }

    /**
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        program.addStoneToCollection(collection);
    }

    @Override
    public String getDescription() {
        return "Додати камінь до колекції";
    }
}
