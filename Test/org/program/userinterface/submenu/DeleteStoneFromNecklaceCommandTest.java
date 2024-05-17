package org.program.userinterface.submenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import program.stones.PreciousStone;
import program.stones.Stone;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.setIn;

class DeleteStoneFromNecklaceCommandTest {
    private List<Stone> necklace;
    private List<Stone> collection;
    private PreciousStone stone;
    private DeleteStoneFromNecklaceCommand command;

    @BeforeEach
    void setUp() {
        collection = new ArrayList<>();
        necklace = new ArrayList<>();
        stone = new PreciousStone("name", "red", 1, 100, 50);
        necklace.add(stone);
        command = new DeleteStoneFromNecklaceCommand(collection, necklace);
    }

    @Test
    void execute() throws IOException {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        setIn(in);

        command.execute();

        List<Stone> tempStorage = new ArrayList<>();
        tempStorage.add(stone);
        Assertions.assertEquals(new ArrayList<>(), necklace);
        Assertions.assertEquals(tempStorage, collection);

        setIn(sysInBackup);
    }
}