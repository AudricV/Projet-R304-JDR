package fr.univ_amu.iut;

import com.opencsv.bean.CsvToBeanBuilder;
import fr.univ_amu.iut.character.Character;
import fr.univ_amu.iut.event.Event;
import fr.univ_amu.iut.item.Item;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static fr.univ_amu.iut.ExitUtils.errorExit;
import static fr.univ_amu.iut.Messages.CHARACTERS;
import static fr.univ_amu.iut.Messages.CSV_EVENTS_ARG_NAME;
import static fr.univ_amu.iut.Messages.CSV_ITEMS_ARG_NAME;
import static fr.univ_amu.iut.Messages.EVENTS;
import static fr.univ_amu.iut.Messages.INVALID_FILE;
import static fr.univ_amu.iut.Messages.ITEMS;
import static fr.univ_amu.iut.Messages.PARSING_ERROR;

/**
 * Class responsible to load CSV files into objects.
 *
 * <p>
 * It uses the OpenCSV library to do this process.
 * </p>
 */
public class CsvLoader {
    private List<Character> characters = Collections.emptyList();
    private List<Event> events = Collections.emptyList();
    private List<Item> items = Collections.emptyList();

    /**
     * Create a new loader instance.
     */
    public CsvLoader() {
        // No arguments needed
    }

    /**
     * Parse CSV files of the characters, the events and the items of the game.
     *
     * <p>
     * The presence of a CSV argument is not checked; this should be done by callers (even if usage
     * of an empty file path is done in this case).
     * </p>
     *
     * <p>
     * If a file path refers to a folder, is invalid or inaccessible, the program will exit with a
     * 0 code.
     * </p>
     *
     * @param mapArgs a {@link Map} of the program arguments
     */
    public void parseCsvs(final Map<String, String> mapArgs) {
        characters = parseCsvAndGetObjectsList(Objects.requireNonNullElse(
                mapArgs.get(Messages.CSV_CHARACTER_ARG_NAME), ""), CHARACTERS, Character.class);
        events = parseCsvAndGetObjectsList(Objects.requireNonNullElse(
                mapArgs.get(CSV_EVENTS_ARG_NAME), ""), EVENTS, Event.class);
        items = parseCsvAndGetObjectsList(Objects.requireNonNullElse(
                mapArgs.get(CSV_ITEMS_ARG_NAME), ""), ITEMS, Item.class);
    }

    /**
     * Parse a given CSV file, using its path, its category and the resulting object class.
     *
     * <p>
     * If a file path refers to a folder, is invalid or inaccessible, the program will exit with a
     * 0 code.
     * </p>
     *
     * @param filePath         the path to the CSV file
     * @param fileCategoryName the name of the category of the file (such as {@code personnages} or
     *                         {@code évènements})
     * @param typeClass        the class of the objects which will be generated when parsing the
     *                         file
     * @param <T>              the object type of entries (such as {@link Character})
     * @return a list of elements of the given class
     */
    private <T> List<T> parseCsvAndGetObjectsList(final String filePath,
                                                  final String fileCategoryName,
                                                  final Class<T> typeClass) {
        try (final FileReader fileReader = new FileReader(filePath, StandardCharsets.UTF_8)) {
            return new CsvToBeanBuilder<T>(fileReader)
                    .withType(typeClass)
                    .withSeparator(';') // Our CSVs use comma separators
                    .build()
                    .parse();
        } catch (final IOException e) {
            System.out.printf(INVALID_FILE, fileCategoryName);
            errorExit();
        } catch (final RuntimeException e) {
            System.out.printf(PARSING_ERROR, fileCategoryName);
            errorExit();
        }

        return Collections.emptyList();
    }

    /**
     * @return the list of {@link Character}s, which is empty if parsing has been not made.
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * @return the list of {@link Item}s, which is empty if parsing has been not made.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @return the list of {@link Event}s, which is empty if parsing has been not made.
     */
    public List<Event> getEvents() {
        return events;
    }
}
