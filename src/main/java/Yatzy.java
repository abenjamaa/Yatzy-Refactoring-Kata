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
        return diceRolls.maxPairValue() * 2;
    }

    public static int twoPair(DiceRolls diceRolls)
    {
        return computeDiceValuesCountSumMultipliedByCount(diceRolls,2);
    }

    public static int fourOfAKind(DiceRolls diceRolls)
    {
        return computeDiceValuesCountSumMultipliedByCount(diceRolls,4);
    }

    public static int threeOfAKind(DiceRolls diceRolls)
    {
        return computeDiceValuesCountSumMultipliedByCount(diceRolls,3);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private static int computeDiceValuesCountSumMultipliedByCount(DiceRolls diceRolls, int count) {
        return Objects.requireNonNullElse(diceRolls, new DiceRolls())
            .getDiceValuesWithCountEqualTo(count)
            .stream()
            .reduce(0, Integer::sum) * count;
    }


}



