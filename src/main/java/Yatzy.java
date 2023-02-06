import java.util.Objects;

/**
 * Yatzi
 */
public class Yatzy {
    private Yatzy(){
        /*constructor*/
    }


    /**
     * Get chance result
     * @param diceRolls the dice Rolls
     */
    public static int chance(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).sum();
    }

    /**
     * Get yatzy result
     * @param diceRolls the dice rolls
     */
    public static int yatzy(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).yatzy();
    }

    /**
     * Get the ones result
     * @param diceRolls the dice rolls
     */
    public static int ones(DiceRolls diceRolls) {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .computeDiceValueMultipliedByOccurrenceCount(DiceValue.ONE.getValue());
    }

    /**
     * Get the twos result
     * @param diceRolls the dice rolls
     */
    public static int twos(DiceRolls diceRolls) {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .computeDiceValueMultipliedByOccurrenceCount(DiceValue.TWO.getValue());
    }

    /**
     * Get the threes result
     * @param diceRolls the dice rolls
     */
    public static int threes(DiceRolls diceRolls) {
        return  Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .computeDiceValueMultipliedByOccurrenceCount(DiceValue.THREE.getValue());
    }

    /**
     * Get the fives result
     * @param diceRolls the dice rolls
     */
    public static int fours(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .computeDiceValueMultipliedByOccurrenceCount(DiceValue.FOUR.getValue());
    }

    /**
     * Get the fives result
     * @param diceRolls the dice rolls
     */
    public static int fives(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .computeDiceValueMultipliedByOccurrenceCount( DiceValue.FIVE.getValue());
    }

    /**
     * Get the sixes result
     * @param diceRolls the dice rolls
     */
    public static int sixes(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .computeDiceValueMultipliedByOccurrenceCount(DiceValue.SIX.getValue());
    }

    /**
     * compute the sum of max pair
     * @param diceRolls the dice Rolls
     */
    public static int sumMaxPair(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).maxPairValue() * 2;
    }

    /**
     * Get sum of two pairs values
     * @param diceRolls the dice Rolls
     */
    public static int twoPairs(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .getSumOfTwoPairs(DiceValueOccurrence.TWO.getValue()) * DiceValueOccurrence.TWO.getValue();
    }

    /**
     * Get sum of four of a kind values
     * @param diceRolls the dice Rolls
     */
    public static int fourOfAKind(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .sumOfDiceValuesWithCountEqualTo(DiceValueOccurrence.FOUR.getValue()) * DiceValueOccurrence.FOUR.getValue();
    }

    /**
     * Get sum of three of a kind values
     * @param diceRolls the dice Rolls
     */
    public static int threeOfAKind(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .sumOfDiceValuesWithCountEqualTo(DiceValueOccurrence.THREE.getValue()) * DiceValueOccurrence.THREE.getValue();
    }

    /**
     * Get small straight result
     * @param diceRolls the dice rolls
     */
    public static int smallStraight(DiceRolls diceRolls)
    {
        DiceRolls diceRolls1 = Objects.requireNonNullElse(diceRolls, new DiceRolls());
        return diceRolls1.toTreeSet().size() == 5 && diceRolls1.toTreeSet().last() == 5 ? 15 : 0;
    }

    /**
     * Get large straight result
      * @param diceRolls the dice rolls
     */
    public static int largeStraight(DiceRolls diceRolls)
    {
        DiceRolls diceRollsNonNull = Objects.requireNonNullElse(diceRolls, new DiceRolls());
        return diceRollsNonNull.toTreeSet().size() == 5 && diceRollsNonNull.toTreeSet().last() == 6 ? 20 : 0;
    }

    /**
     * Get full house result
     * @param diceRolls the dice rolls
     */
    public static int fullHouse(DiceRolls diceRolls)
    {
        DiceRolls diceRollsNonNull = Objects.requireNonNullElse(diceRolls, new DiceRolls());
        return diceRollsNonNull.isFullHouse() ? diceRollsNonNull.sum() : 0;
    }



}



