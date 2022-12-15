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
    static final String GAME_TITLE = "Jeu de rôles - R304";
    static final String CSV_LOAD_TITLE = "Chargement des fichiers ...";
    static final String CSV_LOAD_TITLE_COMPLETE = "Chargement des fichiers terminé";
    static final String HELP_CONTENT = "Usage :\n"
            + HELP_SHORT_ARG_NAME
            + ", "
            + HELP_LONG_ARG_NAME
            + " en premier argument ou aucun argument : afficher cette aide\n"
            + CSV_CHARACTER_ARG_NAME
            + " : emplacement vers le fichier CSV des personnages\n"
            + CSV_EVENTS_ARG_NAME
            + " : emplacement vers le fichier CSV des évènements\n"
            + CSV_ITEMS_ARG_NAME
            + " : emplacement vers le fichier CSV des items\n";

    // Error messages
    static final String INVALID_ARGUMENTS_COUNT_MESSAGE =
            "Nombre d'arguments invalide : 3 paramètres avec leur valeur sont attendus";
    static final String MISSING_ARGUMENTS_MESSAGE = "Usage invalide : argument %s manquant";
    static final String INVALID_FILE =
            "L'emplacement du fichier des %s est inexistant, inaccessible ou fait référence à un dossier.";
    static final String PARSING_ERROR =
            "Erreur lors de l'analyse du fichiers des %s";

    // Elements
    static final String CHARACTERS = "personnages";
    static final String EVENTS = "évènements";
    static final String ITEMS = "items";

    // Game begin
    static final String WELCOME_MESSAGE = "Welcome to Random JDR Quest !";
    static final String SELECT_CHARACTER_CLASS = "Please select you character's class using the numbers provided:";

    static final String SELECT_CHARACTER_NAME = "Choose your character's name:";
    static final String WELCOME_GAME_START = "Welcome %s, you are about to experience an adventure as few live it...";

    // Fights
    static final String FIGHTING_ENEMY = "You are facing the %s";
    static final String ATTACKING_FIRST = "You are attacking first!";
    static final String ACTION_CHOICE = "Do you want to attack or heal? Enter your choice below:";
    static final String PLAYER_ATTACKS_ENEMY = "%s attacks the %s!";
    static final String ENEMY_ATTACKS_YOU = "%s attacks you!";
    static final String CHARACTER_DEALS_DAMAGE = "It deals %d damage(s)!";
    static final String PLAYER_HP_RECOVERED = "You recovered %d HP !";
    static final String PLAYER_WIN = "You win!";
    static final String PLAYER_WIN_GOLD = "You win %d gold !";
    static final String PLAYER_WIN_XP = "You win %d XP!";

    // Levels
    static final String NEXT_LEVEL = "You can go to the next level...";

    // Game end
    static final String NO_HP_LEFT = "No HP left, You are dead...";
    static final String GAME_OVER = "Game Over!";

    private Messages() {
        // Utility class, not instantiation allowed
    }
}
