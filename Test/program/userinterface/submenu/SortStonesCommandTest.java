package program.userinterface.submenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import program.stones.PreciousStone;
import program.stones.Stone;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static java.lang.System.in;
import static java.lang.System.setIn;

class SortStonesCommandTest {
    private List<Stone> storage;
    private PreciousStone stone1;
    private PreciousStone stone2;
    private SortStonesCommand command;

    @BeforeEach
    void setUp() {
        storage = new ArrayList<>();
        stone1 = new PreciousStone("name2", "red", 1, 100, 50);
        stone2 = new PreciousStone("name1", "blue", 1, 100, 50);
        storage.add(stone1);
        storage.add(stone2);
        command = new SortStonesCommand(storage);
    }

    @Test
    void sortByNames() {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("name".getBytes());
        setIn(in);

        command.execute();

        List<Stone> tempStorage = new ArrayList<>();
        tempStorage.add(stone2);
        tempStorage.add(stone1);
        Collator collator = Collator.getInstance(Locale.US);
        storage.sort(Comparator.comparing(Stone::getColor, collator));

        Assertions.assertEquals(tempStorage, storage);

        setIn(sysInBackup);
    }

    @Test
    void sortByType() {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("type".getBytes());
        setIn(in);

        command.execute();

        List<Stone> tempStorage = new ArrayList<>();
        tempStorage.add(stone2);
        tempStorage.add(stone1);
        Collator collator = Collator.getInstance(Locale.US);
        storage.sort(Comparator.comparing(Stone::getColor, collator));

        Assertions.assertEquals(tempStorage, storage);

        setIn(sysInBackup);
    }

    @Test
    void sortByColor() {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("color".getBytes());
        setIn(in);

        command.execute();

        List<Stone> tempStorage = new ArrayList<>();
        tempStorage.add(stone2);
        tempStorage.add(stone1);
        Collator collator = Collator.getInstance(Locale.US);
        storage.sort(Comparator.comparing(Stone::getColor, collator));

        Assertions.assertEquals(tempStorage, storage);

        setIn(sysInBackup);
    }

    @Test
    void sortByWeight() {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("weight".getBytes());
        setIn(in);

        command.execute();

        List<Stone> tempStorage = new ArrayList<>();
        tempStorage.add(stone2);
        tempStorage.add(stone1);
        Collator collator = Collator.getInstance(Locale.US);
        storage.sort(Comparator.comparing(Stone::getColor, collator));

        Assertions.assertEquals(tempStorage, storage);

        setIn(sysInBackup);
    }

    @Test
    void sortByValue() {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("value".getBytes());
        setIn(in);

        command.execute();

        List<Stone> tempStorage = new ArrayList<>();
        tempStorage.add(stone2);
        tempStorage.add(stone1);
        Collator collator = Collator.getInstance(Locale.US);
        storage.sort(Comparator.comparing(Stone::getColor, collator));

        Assertions.assertEquals(tempStorage, storage);

        setIn(sysInBackup);
    }

    @Test
    void sortByTransparency() {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("transparency".getBytes());
        setIn(in);

        command.execute();

        List<Stone> tempStorage = new ArrayList<>();
        tempStorage.add(stone2);
        tempStorage.add(stone1);
        Collator collator = Collator.getInstance(Locale.US);
        storage.sort(Comparator.comparing(Stone::getColor, collator));

        Assertions.assertEquals(tempStorage, storage);

        setIn(sysInBackup);
    }

    @Test
    void getDescription() {
        Assertions.assertEquals("Посортувати камені", command.getDescription());
    }
}