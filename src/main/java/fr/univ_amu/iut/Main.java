package fr.univ_amu.iut;

import java.util.*;

import static fr.univ_amu.iut.Messages.*;

public class Main {
    /**
     * The number of required arguments to run the game.
     */
    private static final int ARGS_REQUIRED_COUNT = 6;

    public static void main(final String[] args) {
        System.out.println(GAME_TITLE);

        // Show the help message in the case no arguments are passed or the first argument is -h or
        // --help (case sensitive)
        if (args == null || args.length == 0
                || args[0].equalsIgnoreCase(HELP_SHORT_ARG_NAME)
                || args[0].equalsIgnoreCase(HELP_LONG_ARG_NAME)) {
            showHelp();
        }

        // Suppress the null pointer exception warning, as the program is stopped above if the args
        // string array is null
        //noinspection ConstantConditions
        if (args.length < ARGS_REQUIRED_COUNT) {
            System.out.println(INVALID_ARGUMENTS_COUNT_MESSAGE);
            errorExit();
        }

        // Parse arguments from the string args array
        final Map<String, String> mapArgs = new HashMap<>();
        // We browse each required argument with its value
        for (int i = 0; i < ARGS_REQUIRED_COUNT; i += 2) {
            mapArgs.put(args[i], args[i + 1]);
        }

        checkRequiredArguments(mapArgs);

        System.out.println(CSV_LOAD_TITLE);
    }

    /**
     * Show the help message of the game and stops its execution with an exit code 0.
     */
    private static void showHelp() {
        System.out.println(HELP_CONTENT);
        System.exit(0);
    }

    /**
     * Stops the game's execution with an exit code 1.
     */
    private static void errorExit() {
        System.exit(1);
    }

    /**
     * Show the missing argument message of a given file type and exit with an error code using
     * {@link #errorExit()}.
     *
     * @param argumentType a "human" file type argument, to be inserted as {@code ARGUMENT_TYPE} in
     *                     the following message:
     *                     {@code "Usage invalide : argument " + ARGUMENT_TYPE + " manquant"}
     */
    private static void showMissingFileArgValueMessageAndExit(final String argumentType) {
        System.out.printf(Messages.MISSING_ARGUMENTS_MESSAGE, argumentType);
        errorExit();
    }

    /**
     * Check whether required arguments have been provided.
     *
     * @param mapArgs the {@link Map} of arguments and values, which comes from the string array of
     *                arguments; keys must be arguments and values the value of arguments
     */
    private static void checkRequiredArguments(final Map<String, String> mapArgs) {
        if (!mapArgs.containsKey(CSV_CHARACTER_ARG_NAME)) {
            showMissingFileArgValueMessageAndExit("personnages");
        }

        if (!mapArgs.containsKey(CSV_EVENTS_ARG_NAME)) {
            showMissingFileArgValueMessageAndExit("évènements");
        }

        if (!mapArgs.containsKey(CSV_ITEMS_ARG_NAME)) {
            showMissingFileArgValueMessageAndExit("items");
        }
    }
}
