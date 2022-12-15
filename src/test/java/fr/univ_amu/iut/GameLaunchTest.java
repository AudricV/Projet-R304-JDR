package fr.univ_amu.iut;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Test;

import static fr.univ_amu.iut.Messages.*;
import static fr.univ_amu.iut.TestUtils.getResourcePath;
import static org.mockito.Mockito.verify;

/**
 * Test to verify whether game is launched only when arguments are required.
 */
class GameLaunchTest extends BasicTest {
    @ExpectSystemExitWithStatus(0)
    @Test
    void noAppArgsShouldShowHelp() {
        Main.main(null);
        verify(systemOutput).println(GAME_TITLE);
        verify(systemOutput).println(HELP_CONTENT);
    }

    @ExpectSystemExitWithStatus(0)
    @Test
    void helpShortArgShouldShowHelp() {
        Main.main(new String[]{HELP_SHORT_ARG_NAME, "argument"});
        verify(systemOutput).println(GAME_TITLE);
        verify(systemOutput).println(HELP_CONTENT);
    }

    @ExpectSystemExitWithStatus(0)
    @Test
    void helpLongArgShouldShowHelp() {
        Main.main(new String[]{HELP_LONG_ARG_NAME, "argument"});
        verify(systemOutput).println(GAME_TITLE);
        verify(systemOutput).println(HELP_CONTENT);
    }

    @ExpectSystemExitWithStatus(1)
    @Test
    void invalidArgsCountShouldShowCorrespondingMessage() {
        Main.main(new String[]{CSV_EVENTS_ARG_NAME, "events.csv"});
        verify(systemOutput).println(GAME_TITLE);
        verify(systemOutput).println(INVALID_ARGUMENTS_COUNT_MESSAGE);
    }

    @ExpectSystemExitWithStatus(1)
    @Test
    void missingRequiredArgumentShouldShowErrorMessage() {
        Main.main(new String[]{"--csv-file", "events.csv",
                CSV_CHARACTER_ARG_NAME, "characters.csv",
                CSV_ITEMS_ARG_NAME, "items.csv"});

        verify(systemOutput).println(GAME_TITLE);
        verify(systemOutput).println(MISSING_ARGUMENTS_MESSAGE);
    }

    @Test
    void validArgsCountShouldNotShowErrorMessage() {
        Main.main(new String[]{CSV_EVENTS_ARG_NAME, getResourcePath("events.csv"),
                CSV_CHARACTER_ARG_NAME, getResourcePath("characters.csv"),
                CSV_ITEMS_ARG_NAME, getResourcePath("items.csv")});

        verify(systemOutput).println(GAME_TITLE);
    }

    @Test
    void validArgsAndFilesShouldLoadGame() {
        Main.main(new String[]{CSV_EVENTS_ARG_NAME, getResourcePath("events.csv"),
                CSV_CHARACTER_ARG_NAME, getResourcePath("characters.csv"),
                CSV_ITEMS_ARG_NAME, getResourcePath("items.csv")});

        verify(systemOutput).println(GAME_TITLE);
        verify(systemOutput).println(CSV_LOAD_TITLE);
        verify(systemOutput).println(CSV_LOAD_TITLE_COMPLETE);
    }
}
