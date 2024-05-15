package org.program.userinterface.menuinterface;

public class BeautifulOutput {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001B[31m";

    /**
     * @param string
     */
    public static void printYellow(String string) {
        System.out.println(ANSI_YELLOW + string + ANSI_RESET);
    }

    /**
     * @param string
     */
    public static void printPurple(String string) {
        System.out.println(ANSI_PURPLE + string + ANSI_RESET);
    }

    /**
     * @param string
     */
    public static void printGreen(String string) {
        System.out.print(ANSI_GREEN + string + ANSI_RESET);
    }

    /**
     * @param string
     */
    public static void printBlue(String string) {
        System.out.print(ANSI_BLUE + string + ANSI_RESET);
    }

    /**
     * @param string
     */
    public static void printRed(String string) {
        System.out.println(ANSI_RED + string + ANSI_RESET);
    }
}
