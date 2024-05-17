package org.program.userinterface.menuinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.userinterface.interfaceClass.Command;
import org.program.userinterface.mainmenu.ExitCommand;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;
import static java.lang.System.setIn;

class MainMenuTest {
    private MainMenu mainMenu;
    private Map<String, Command> commandMap;

    @BeforeEach
    public void setUp() {
        commandMap = new LinkedHashMap<>();
        commandMap.put("exit", new ExitCommand());
        mainMenu = new MainMenu(commandMap);
    }

    @Test
    void execute() throws IOException {
        InputStream sysInBackup = in;
        ByteArrayInputStream in = new ByteArrayInputStream("exit".getBytes());
        setIn(in);

        Command exit = mainMenu.execute();

        Assertions.assertEquals(ExitCommand.class, exit.getClass());

        setIn(sysInBackup);
    }
}