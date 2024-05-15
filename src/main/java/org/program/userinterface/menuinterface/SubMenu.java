package org.program.userinterface.menuinterface;

import org.program.userinterface.interfaceClass.Command;

import java.util.Map;

public class SubMenu extends MainMenu {
    /**
     * @param commandMap
     */
    public SubMenu(Map<String, Command> commandMap) {
        super(commandMap);
    }

    @Override
    public void show() {
        BeautifulOutput.printPurple("\nСписок команд:");
        int index = 1;
        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            System.out.print((index++) + ") ");
            BeautifulOutput.printBlue(entry.getKey());
            System.out.println(" (" + entry.getValue().getDescription() + ")");
        }
    }
}
