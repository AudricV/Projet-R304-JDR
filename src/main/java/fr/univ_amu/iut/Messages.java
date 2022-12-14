package fr.univ_amu.iut;

/**
 * String resources which are used for system outputs.
 *
 * <p>
 * Some of them can be string formats.
 * </p>
 */
final class Messages {
    // Command-line arguments names
    static final String CSV_CHARACTER_ARG_NAME = "--characters-file";
    static final String CSV_EVENTS_ARG_NAME = "--events-file";
    static final String CSV_ITEMS_ARG_NAME = "--items-file";
    static final String HELP_SHORT_ARG_NAME = "-h";
    static final String HELP_LONG_ARG_NAME = "-help";

    // Game section titles
    static final String GAME_TITLE = "Role play - R304";
    static final String CSV_LOAD_TITLE = "Loading files...";
    static final String CSV_LOAD_TITLE_COMPLETE = "Files loaded.";
    static final String HELP_CONTENT = "Usage :\n"
            + HELP_SHORT_ARG_NAME
            + ", "
            + HELP_LONG_ARG_NAME
            + " as a first argument or no argument: show this help\n"
            + CSV_CHARACTER_ARG_NAME
            + ": path to the characters' CSV file\n"
            + CSV_EVENTS_ARG_NAME
            + ": path to the characters' CSV events\n"
            + CSV_ITEMS_ARG_NAME
            + ": path to the characters' CSV items\n";

    // Error messages
    static final String INVALID_ARGUMENTS_COUNT_MESSAGE =
            "Invalid arguments count: 3 parameters with their value are required";
    static final String MISSING_ARGUMENTS_MESSAGE = "Invalid usage : argument %s is missing";
    static final String INVALID_FILE =
            "%s' path references a nonexistent or an inaccessible file, or a folder.";
    static final String PARSING_ERROR =
            "Error when parsing %s' file";

    // Elements
    static final String CHARACTERS = "characters";
    static final String EVENTS = "events";
    static final String ITEMS = "items";

    // Game begin
    static final String WELCOME_MESSAGE = "Welcome to Random JDR Quest!";
    static final String SELECT_CHARACTER_CLASS = "Please select you character's class using the numbers provided:";

    static final String SELECT_CHARACTER_NAME = "Choose your character's name:";
    static final String WELCOME_GAME_START = "Welcome %s, you are about to experience an adventure as few live it...";

    // Fights
    static final String FIGHTING_ENEMY = "You are facing the %s!\n";
    static final String ATTACKING_FIRST = "You are attacking first!";
    static final String ACTION_CHOICE = "Do you want to attack or heal? Enter your choice below:";
    static final String PLAYER_ATTACKS_ENEMY = "%s attacks the %s!\n";
    static final String ENEMY_ATTACKS_YOU = "%s attacks you!";
    static final String CHARACTER_DEALS_DAMAGE = "It deals %d damage(s)!\n";
    static final String PLAYER_HP_RECOVERED = "You recovered %d HP!";
    static final String PLAYER_WIN = "You win!";
    static final String PLAYER_WIN_GOLD = "You win %d gold!";
    static final String PLAYER_WIN_XP = "You win %d XP!";

    // Levels
    static final String NEXT_LEVEL = "You can go to the next level...";

    // Game end
    static final String NO_HP_LEFT = "No HP left, you are dead...";
    static final String GAME_OVER = "Game Over!";

    private Messages() {
        // Utility class, not instantiation allowed
    }
}
