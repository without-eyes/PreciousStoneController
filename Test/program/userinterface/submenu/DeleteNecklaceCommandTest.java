package program.userinterface.submenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import program.stones.PreciousStone;
import program.stones.Stone;

import java.util.ArrayList;
import java.util.List;

class DeleteNecklaceCommandTest {
    private List<Stone> necklace;
    private PreciousStone stone;
    private DeleteNecklaceCommand command;

    @BeforeEach
    void setUp() {
        necklace = new ArrayList<>();
        stone = new PreciousStone("name", "red", 1, 100, 50);
        necklace.add(stone);
        command = new DeleteNecklaceCommand(necklace);
    }

    @Test
    void execute() {
        command.execute();
        Assertions.assertEquals(new ArrayList<>(), necklace);
    }

    @Test
    void getDescription() {
        Assertions.assertEquals("Видалення намиста", command.getDescription());
    }
}