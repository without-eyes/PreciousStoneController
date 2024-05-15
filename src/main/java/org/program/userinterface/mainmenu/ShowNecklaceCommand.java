package org.program.userinterface.mainmenu;

import org.program.execution.Program;
import org.program.stones.Stone;
import org.program.userinterface.interfaceClass.Command;

import java.io.IOException;
import java.util.List;

public class ShowNecklaceCommand implements Command {
    private final Program program;
    private final List<Stone> collection;
    private final List<Stone> necklace;

    /**
     * @param program
     * @param collection
     * @param necklace
     */
    public ShowNecklaceCommand(Program program, List<Stone> collection, List<Stone> necklace) {
        this.program = program;
        this.collection = collection;
        this.necklace = necklace;
    }

    /**
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        program.showNecklace(collection, necklace);
    }

    @Override
    public String getDescription() {
        return "Показати намисто";
    }
}
