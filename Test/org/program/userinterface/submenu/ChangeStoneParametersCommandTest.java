package org.program.userinterface.submenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.stones.PreciousStone;
import org.program.stones.SemiPreciousStone;
import org.program.stones.Stone;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setIn;

class ChangeStoneParametersCommandTest {
    private List<Stone> collection;
    private PreciousStone stone;
    private ChangeStoneParametersCommand command;

    @BeforeEach
    void setUp() {
        collection = new ArrayList<>();
        stone = new PreciousStone("name", "red", 1, 100, 50);
        collection.add(stone);
        command = new ChangeStoneParametersCommand(collection);
    }

    @Test
    void execute() throws IOException {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\nname\nname2".getBytes());
        setIn(in);

        command.execute();

        stone.setName("name2");
        Assertions.assertEquals(stone, collection.get(0));

        setIn(sysInBackup);
    }

    @Test
    void menu() {
        String[] menu = {"\nЯкий параметр ви хочете змінити: ",
                "name",
                "type",
                "color",
                "weight",
                "value",
                "transparency",
                "go back"};
        Assertions.assertArrayEquals(menu, command.menu());
    }

    @Test
    void newName() {
        List<Stone> tempStorage = collection;
        collection.get(0).setName("name");

        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("name".getBytes());
        setIn(in);

        command.newName(new Scanner(System.in), 0);

        Assertions.assertEquals(tempStorage, collection);

        setIn(sysInBackup);
    }

    @Test
    void newType() {
        List<Stone> tempStorage = collection;
        tempStorage.add(new SemiPreciousStone(collection.get(0).getName(),
                collection.get(0).getColor(),
                collection.get(0).getWeight(),
                collection.get(0).getValue(),
                collection.get(0).getTransparency()));

        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("напівкоштовний".getBytes());
        setIn(in);

        command.newType(new Scanner(System.in), 0);

        Assertions.assertEquals(tempStorage, collection);

        setIn(sysInBackup);
    }

    @Test
    void newColor() {
        List<Stone> tempStorage = collection;
        collection.get(0).setColor("color");

        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("color".getBytes());
        setIn(in);

        command.newColor(new Scanner(System.in), 0);

        Assertions.assertEquals(tempStorage, collection);

        setIn(sysInBackup);
    }

    @Test
    void newWeight() {
        List<Stone> tempStorage = collection;
        collection.get(0).setWeight(10);

        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("10".getBytes());
        setIn(in);

        command.newWeight(new Scanner(System.in), 0);

        Assertions.assertEquals(tempStorage, collection);

        setIn(sysInBackup);
    }

    @Test
    void newValue() {
        List<Stone> tempStorage = collection;
        collection.get(0).setValue(50);

        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("50".getBytes());
        setIn(in);

        command.newValue(new Scanner(System.in), 0);

        Assertions.assertEquals(tempStorage, collection);

        setIn(sysInBackup);
    }

    @Test
    void newTransparency() {
        List<Stone> tempStorage = collection;
        collection.get(0).setTransparency(10);

        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("10".getBytes());
        setIn(in);

        command.newTransparency(new Scanner(System.in), 0);

        Assertions.assertEquals(tempStorage, collection);

        setIn(sysInBackup);
    }
}