package fr.univ_amu.iut;

import static fr.univ_amu.iut.Messages.*;

/**
 * Utility class to do common {@link System#exit(int) System.exit} calls in the game
 */
public class ExitUtils {
    private ExitUtils() {
    }

    /**
     * Show the help message of the game and stops its execution with an exit code 0.
     */
    public static void showHelp() {
        System.out.println(HELP_CONTENT);
        System.exit(0);
    }

    /**
     * Stops the game's execution with an exit code 1.
     */
    public static void errorExit() {
        System.exit(1);
    }
}
