package program.userinterface.submenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import program.stones.PreciousStone;
import program.stones.Stone;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.setIn;

class DeleteStoneFromCollectionCommandTest {
    private List<Stone> collection;
    private PreciousStone stone;
    private DeleteStoneFromCollectionCommand command;

    @BeforeEach
    void setUp() {
        collection = new ArrayList<>();
        stone = new PreciousStone("name", "red", 1, 100, 50);
        collection.add(stone);
        command = new DeleteStoneFromCollectionCommand(collection);
    }

    @Test
    void execute() {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        setIn(in);

        command.execute();

        Assertions.assertEquals(new ArrayList<>(), collection);

        setIn(sysInBackup);
    }

    @Test
    void getDescription() {
        Assertions.assertEquals("Видалити камінь з колекції", command.getDescription());
    }
}