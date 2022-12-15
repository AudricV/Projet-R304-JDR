package fr.univ_amu.iut;

import fr.univ_amu.iut.character.Character;
import fr.univ_amu.iut.event.*;
import fr.univ_amu.iut.exceptions.*;

import java.util.*;

import static fr.univ_amu.iut.Messages.*;

/**
 * Class responsible to manage a game.
 */
public class GameManager {
    private final List<Event> events;
    private final List<Character> characters;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    /**
     * The {@link Character} which will be selected by the player.
     */
    private Character selectedCharacter;

    /**
     * Create a {@link GameManager} instance.
     *
     * @param events     the {@link List} of {@link Event}s parsed
     * @param characters the {@link List} of {@link Character}s parsed
     */
    public GameManager(final List<Event> events,
                       final List<Character> characters) {
        this.events = List.copyOf(events);
        this.characters = List.copyOf(characters);
    }

    /**
     * Method to launch the select character class invite.
     *
     * <p>
     * It will first display a welcome message, then the character selection message, then select
     * the character corresponding to the given the choice.
     * </p>
     */
    public void chooseClass() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(SELECT_CHARACTER_CLASS);

        final List<Character> playableCharacters = new ArrayList<>();
        // Remove Monster and Boss characters, as they are not playable characters
        for (final Character character : characters) {
            if (!"Monster".equalsIgnoreCase(character.getType())
                    && !"Boss".equalsIgnoreCase(character.getType())) {
                playableCharacters.add(character);
            }
        }

        for (int i = 0; i < playableCharacters.size(); i++) {
            Character character = playableCharacters.get(i);
            System.out.println(i + " - " + character.getType());
        }

        final int selectedCharacterIndex = scanner.nextInt();
        selectedCharacter = playableCharacters.get(selectedCharacterIndex);
    }

    /**
     * Method to ask user to set a name on its character and show a game start message.
     *
     * <p>
     * The character which will be played must be set before this method is called
     * ({@link #chooseClass()}).
     * </p>
     */
    public void chooseName() {
        System.out.println(SELECT_CHARACTER_NAME);

        final String playerName = scanner.next();
        selectedCharacter.setName(playerName);
        System.out.printf(WELCOME_GAME_START, playerName);
    }

    /**
     * Starts an adventure.
     *
     * <p>
     * This method will take all the adventure events and choose randomly one, using the
     * {@link Random} stored as a class field. This process is then repeated for the fight events.
     * </p>
     *
     * <p>
     * Finally, it will start a fight of the enemy defined in the adventure (an exception is thrown if
     * no corresponding enemy has been found in the enemies list).
     * </p>
     */
    public void adventure() {
        final List<Event> adventureEvents = new ArrayList<>();
        for (final Event event : events) {
            if (event.getEventType() == EventType.ADVENTURE) {
                adventureEvents.add(event);
            }
        }

        final int adventureIndex = random.nextInt(0, adventureEvents.size());
        System.out.println(adventureEvents.get(adventureIndex).getTextEvent());

        final List<Event> fightEvents = new ArrayList<>();
        for (final Event event : events) {
            if (event.getEventType() == EventType.FIGHT) {
                fightEvents.add(event);
            }
        }

        int indexFight = random.nextInt(0, fightEvents.size());
        final Event fightEvent = fightEvents.get(indexFight);
        final String eventCharacterName = fightEvent.getName();
        System.out.println(fightEvent.getTextEvent());

        Character adventureEnemy = null;

        for (final Character character : characters) {
            if (Objects.equals(character.getName(), eventCharacterName)) {
                adventureEnemy = character;
                break;
            }
        }

        if (adventureEnemy == null) {
            throw new RuntimeException(new MissingCharacterException("Missing character match from event"));
        }

        doCombat(adventureEnemy);
    }

    /**
     * Make a fight against a regular enemy, randomly chosen from the enemies monster list.
     */
    public void combat() {
        doCombat(generateRegularEnemy());
    }

    /**
     * Do a fight.
     *
     * <p>
     * It will ask the user to choose between attacking the enemy or healing, and this process is
     * repeated until someone dies.
     * </p>
     *
     * <p>
     * If that's the player, the game is stopped (game over).
     * </p>
     *
     * @param enemy the {@link Character} representing an enemy
     */
    private void doCombat(final Character enemy) {
        Fight fight = new Fight(selectedCharacter, enemy, random);
        System.out.printf(FIGHTING_ENEMY, enemy.getName());

        int whoAttackFirst = random.nextInt(2);

        if (whoAttackFirst == 0) {
            System.out.println(ATTACKING_FIRST);

            while (true) {
                System.out.println(ACTION_CHOICE);

                switch (scanner.next().trim().toLowerCase()) {
                    case "attack":
                        fight.attack();
                        break;
                    case "heal":
                        fight.heal();
                        break;
                    default:
                        continue;
                }

                if (checkIfWinOrGameOver(enemy)) {
                    break; // This should be never reached, as System.exit should exit the program
                }

                fight.enemyAttack(); // Enemy's turn

                if (checkIfWinOrGameOver(enemy)) {
                    break; // This should be never reached, as System.exit should exit the program
                }
            }
        } else {
            while (true) {
                fight.enemyAttack(); // Enemy's turn

                if (checkIfWinOrGameOver(enemy)) {
                    break; // This should be never reached, as System.exit should exit the program
                }

                System.out.println(ACTION_CHOICE);

                switch (scanner.next().trim().toLowerCase()) {
                    case "attack":
                        fight.attack();
                        break;
                    case "heal":
                        fight.heal();
                        break;
                    default:
                        continue;
                }

                if (checkIfWinOrGameOver(enemy)) {
                    break; // This should be never reached, as System.exit should exit the program
                }
            }
        }
    }

    /**
     * Check whether the player wins or the game is over.
     *
     * <p>
     * A player wins if the enemy has no health points remaining
     * </p>
     *
     * @param enemy the {@link Character} representing the enemy
     * @return whether the player wins or the game is over
     */
    private boolean checkIfWinOrGameOver(final Character enemy) {
        if (selectedCharacter.getHealthPoints() <= 0) {
            System.out.println(NO_HP_LEFT);
            System.out.println(GAME_OVER);

            System.exit(0); // GAME OVER
        } else if (enemy.getHealthPoints() <= 0) {
            System.out.println(PLAYER_WIN);

            selectedCharacter.setGoldAmount(selectedCharacter.getGoldAmount() + enemy.getGoldAmount());
            selectedCharacter.setXp(selectedCharacter.getXp() + enemy.getXp());

            System.out.printf(PLAYER_WIN_GOLD, enemy.getGoldAmount());
            System.out.printf(PLAYER_WIN_XP, enemy.getXp());
            return true;
        }

        return false;
    }

    /**
     * Generate a regular enemy.
     *
     * <p>
     * This enemy is took from the enemies list randomly, using the {@link Random} stored as a
     * class field.
     * </p>
     *
     * @return a regular enemy
     */
    private Character generateRegularEnemy() {
        final List<Character> adventureEnemy = new ArrayList<>();
        for (final Character character : characters) {
            // Exclude bosses, as they are supposed to be played at the end of the file
            if (character.getType().trim().equalsIgnoreCase("monster")) {
                adventureEnemy.add(character);
            }
        }
        int indexEnemy = random.nextInt(0, adventureEnemy.size());
        return adventureEnemy.get(indexEnemy);
    }
}
