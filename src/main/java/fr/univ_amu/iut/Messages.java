package fr.univ_amu.iut;

/**
 * String resources which are used for system outputs.
 *
 * <p>
 * Some of them can be string formats.
 * </p>
 */
public final class Messages {
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

    private Messages() {
    }
}
