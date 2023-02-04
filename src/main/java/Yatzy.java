import java.util.Objects;

public class Yatzy {
    private Yatzy(){}

    public static int chance(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).sum();
    }

    public static int yatzy(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).isYatzy();
    }


    public static int ones(DiceRolls diceRolls) {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).computeDiceFaceValueMultipliedByDiceFaceValueCount(DiceFace.ONE.getValue());
    }

    public static int twos(DiceRolls diceRolls) {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).computeDiceFaceValueMultipliedByDiceFaceValueCount(DiceFace.TWO.getValue());
    }

    public static int threes(DiceRolls diceRolls) {
        return  Objects.requireNonNullElse(diceRolls, new DiceRolls()).computeDiceFaceValueMultipliedByDiceFaceValueCount(DiceFace.THREE.getValue());
    }

    public static int fours(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).computeDiceFaceValueMultipliedByDiceFaceValueCount(DiceFace.FOUR.getValue());
    }

    public static int fives(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).computeDiceFaceValueMultipliedByDiceFaceValueCount( DiceFace.FIVE.getValue());
    }

    public static int sixes(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).computeDiceFaceValueMultipliedByDiceFaceValueCount(DiceFace.SIX.getValue());
    }

    public static int sumMaxPair(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls()).maxPairValue() * 2;
    }

    public static int twoPair(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .sumOfDiceValuesWithCountEqualTo(DiceFaceCount.TWO.getValue()) * DiceFaceCount.TWO.getValue();
    }

    public static int fourOfAKind(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .sumOfDiceValuesWithCountEqualTo(DiceFaceCount.FOUR.getValue()) * DiceFaceCount.FOUR.getValue();
    }

    public static int threeOfAKind(DiceRolls diceRolls)
    {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .sumOfDiceValuesWithCountEqualTo(DiceFaceCount.THREE.getValue()) * DiceFaceCount.THREE.getValue();
    }

    public static int smallStraight(DiceRolls diceRolls)
    {
        DiceRolls diceRolls1 = Objects.requireNonNullElse(diceRolls, new DiceRolls());
        return diceRolls1.getStraight().size() == 5 && diceRolls1.getStraight().last() == 5 ? 15 : 0;
    }

    public static int largeStraight(DiceRolls diceRolls)
    {
        DiceRolls diceRollsNonNull = Objects.requireNonNullElse(diceRolls, new DiceRolls());
        return diceRollsNonNull.getStraight().size() == 5 && diceRollsNonNull.getStraight().last() == 6 ? 20 : 0;
    }

    public static int fullHouse(DiceRolls diceRolls)
    {
        DiceRolls diceRollsNonNull = Objects.requireNonNullElse(diceRolls, new DiceRolls());
        return diceRollsNonNull.fullHouse() ? diceRollsNonNull.sum() : 0;
    }



}



