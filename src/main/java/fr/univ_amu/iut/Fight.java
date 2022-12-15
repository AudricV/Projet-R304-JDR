package fr.univ_amu.iut;

import fr.univ_amu.iut.character.Character;

import java.util.Random;

import static fr.univ_amu.iut.Messages.*;

/**
 * Class responsible for a game fight.
 *
 * <p>
 * It removes or add the health to the enemy or the player, based on the stats of their enemy and
 * their defense, and can also heal the player with the {@link #heal()} method.
 * </p>
 */
public class Fight {
    private final Character player;
    private final Character enemy;
    private final Random random;

    /**
     * Constructs a new {@link Fight} instance.
     *
     * @param player a {@link Character} representing a player
     * @param enemy  a {@link Character} representing an enemy
     * @param random a random to define how many health points are won by the player, each time it
     *               wants to heal
     */
    public Fight(final Character player,
                 final Character enemy,
                 final Random random) {
        this.player = player;
        this.enemy = enemy;
        this.random = random;
    }

    /**
     * Make a player attack to the enemy.
     */
    public void attack() {
        System.out.printf(PLAYER_ATTACKS_ENEMY, player.getName(), enemy.getName());
        dealDamage(player, enemy);
    }

    /**
     * Make an enemy attack to the player.
     */
    public void enemyAttack() {
        System.out.printf(ENEMY_ATTACKS_YOU, enemy.getName());
        dealDamage(enemy, player);
    }

    /**
     * Heal the player randomly between 0 and 10 health points, using the {@link Random} field.
     */
    public void heal() {
        // /!\ HP recover is between 0 and 10
        final int healedHealthPoints = random.nextInt(1, 11);
        // /!\ There is no max HP yet !
        player.setHealthPoints(player.getHealthPoints() + healedHealthPoints);
        System.out.printf(PLAYER_HP_RECOVERED, healedHealthPoints);
    }

    /**
     * Do dealing damages.
     *
     * <p>
     * Dealing damage remove health of the character taking damage.
     * </p>
     *
     * <p>
     * The damage given is calculated using the following way:
     * <br>
     * {@code strength of the character dealing damage - defense of the character taking damage}
     * </p>
     *
     * <p>
     * If the result of this operation is negative, no damage is, of course, dealt.
     * </p>
     *
     * <p>
     * The amount of damage dealt is printed to the standard output.
     * </p>
     *
     * @param characterDealingDamage   the {@link Character} dealing damage
     * @param characterReceivingDamage the {@link Character} receiving damage
     */
    private void dealDamage(final Character characterDealingDamage,
                            final Character characterReceivingDamage) {
        int damages = characterDealingDamage.getStrength() - characterReceivingDamage.getDefense();

        // The character dealing damage doesn't do too much damage, so the character which should
        // have received damage doesn't take any damage
        if (damages < 0) {
            damages = 0;
        }

        player.setHealthPoints(player.getHealthPoints() - damages);
        System.out.printf(CHARACTER_DEALS_DAMAGE, damages);
    }
}
