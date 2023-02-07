import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {


    @Test
    public void shouldReturnFifteenWhenChanceResultsIsFifteen(){
        //GIVEN
        int expectedResult = 15;
        DiceRolls diceRolls = new DiceRolls(2, 3, 4, 5, 1);
        //WHEN
        int actual = Yatzy.chance(diceRolls);
        //THEN
        assertEquals(expectedResult, actual);
    }
    @Test
    public void shouldReturnSixteenWhenChanceResultsIsSixteen() {
        //GIVEN
        int expectedResult = 16;
        DiceRolls diceRolls = new DiceRolls(3,3,4,5,1);
        //WHEN
        int actual = Yatzy.chance(diceRolls);
        //THEN
        assertEquals(expectedResult, actual);
    }

    @Test
    public void shouldReturnZeroWhenDiceRollsIsNull() {
        //GIVEN
        int expectedResult = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.chance(diceRolls);
        //THEN
        assertEquals(expectedResult, actual);
    }

    @Test
    public void shouldReturnFifteenWhenRollsResultIsSameFiveTimes(){
        //GIVEN
        int expectedResult = 50;
        DiceRolls diceRollsOne = new DiceRolls(1,1,1,1,1);
        DiceRolls diceRollsTwo = new DiceRolls(2,2,2,2,2);
        DiceRolls diceRollsThree = new DiceRolls(3,3,3,3,3);
        DiceRolls diceRollsFour = new DiceRolls(4,4,4,4,4);
        DiceRolls diceRollsFive = new DiceRolls(5,5,5,5,5);
        DiceRolls diceRollsSix = new DiceRolls(6,6,6,6,6);
        //WHEN
        int yatzyResultOne = Yatzy.yatzy(diceRollsOne);
        int yatzyResultTwo = Yatzy.yatzy(diceRollsTwo);
        int yatzyResultThree = Yatzy.yatzy(diceRollsThree);
        int yatzyResultFour = Yatzy.yatzy(diceRollsFour);
        int yatzyResultFive = Yatzy.yatzy(diceRollsFive);
        int yatzyResultSix = Yatzy.yatzy(diceRollsSix);

        //THEN
        assertEquals(expectedResult, yatzyResultOne);
        assertEquals(expectedResult, yatzyResultTwo);
        assertEquals(expectedResult, yatzyResultThree);
        assertEquals(expectedResult, yatzyResultFour);
        assertEquals(expectedResult, yatzyResultFive);
        assertEquals(expectedResult, yatzyResultSix);
    }
    @Test public void shouldReturnZeroWhenRollsResultIsNotSameFiveTimes() {
        //GIVEN
        int expectedResult = 0;
        DiceRolls diceRolls = new  DiceRolls(6,6,6,6,3);
        //WHEN
        int diceRollsResult = Yatzy.yatzy(diceRolls);
        //THEN
        assertEquals(expectedResult, diceRollsResult);
    }
    @Test public void shouldReturnTheSumOfOnesInDiceRolls() {
        //GIVEN
        DiceRolls oneTimeOfOne = new DiceRolls(1, 2, 3, 4, 5);
        DiceRolls twoTimesOfOne = new DiceRolls(1,2,1,4,5);
        DiceRolls noOne = new DiceRolls(6,2,2,4,5);
        DiceRolls fourTimesOfOne = new DiceRolls(1,2,1,1,1);
        int expectedForZeroTime = 0;
        int expectedForOneTime = 1;
        int expectedForTwoTimes = 2;
        int  expectedForFourTimes  = 4;

        //WHEN
        int actualForZero = Yatzy.ones(noOne);
        int actualForOneTimes = Yatzy.ones(oneTimeOfOne);
        int actualForTwoTimes = Yatzy.ones(twoTimesOfOne);
        int actualForFourTimes = Yatzy.ones(fourTimesOfOne);

        //THEN
        assertEquals(expectedForZeroTime, actualForZero);
        assertEquals(expectedForOneTime, actualForOneTimes);
        assertEquals(expectedForTwoTimes, actualForTwoTimes);
        assertEquals(expectedForFourTimes, actualForFourTimes);
    }

    @Test
    public void onesShouldReturnZeroWhenDiceRollsIsNull() {
        //GIVEN
        int expected = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.ones(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSumOfTwosInDiceRolls() {
        //GIVEN
        DiceRolls twoTimesOfTwo = new DiceRolls(1,2,3,2,3);
        DiceRolls fiveTimesOfTwo = new DiceRolls(2,2,2,2,2);
        int expectedForTwoTimes = 4;
        int  expectedForFiveTimes  = 10;

        //WHEN
        int actualForTwoTimes = Yatzy.twos(twoTimesOfTwo);
        int actualForFiveTimes = Yatzy.twos(fiveTimesOfTwo);

        //THEN
        assertEquals(expectedForTwoTimes, actualForTwoTimes);
        assertEquals(expectedForFiveTimes, actualForFiveTimes);
    }

    @Test
    public void twosShouldReturnZeroWhenDiceRollsIsNull() {
        //GIVEN
        int expected = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.twos(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSumOfThreesInDiceRolls() {
        //GIVEN
        DiceRolls twoTimesOfThree = new DiceRolls(1,2,3,2,3);
         DiceRolls fourTimesOfThree = new DiceRolls(2,3,3,3,3);
        int expectedForTwoTimes = 6;
        int  expectedForFourTimes  = 12;

        //WHEN
        int actualForTwoTimes = Yatzy.threes(twoTimesOfThree);
        int actualForFourTimes = Yatzy.threes(fourTimesOfThree);


        //THEN
        assertEquals(expectedForTwoTimes, actualForTwoTimes);
        assertEquals(expectedForFourTimes, actualForFourTimes);

    }

    @Test
    public void threesShouldReturnZeroWhenDiceRollsIsNull() {
        //GIVEN
        int expected = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.threes(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSumOfFoursInDiceRolls()
    {
        //GIVEN
        DiceRolls threeTimesOfFour = new DiceRolls(4,4,4,5,5);
        DiceRolls twoTimesOfFour = new DiceRolls(4,4,5,5,5);
        DiceRolls oneTimeOfFour = new DiceRolls(4,5,5,5,5);
        int expectedForTwoTimes = 8;
        int expectedForThreeTimes = 12;
        int  expectedForOneTime  = 4;

        //WHEN
        int actualForTwoTimes = Yatzy.fours(twoTimesOfFour);
        int actualForThreeTimes = Yatzy.fours(threeTimesOfFour);
        int actualForOneTime = Yatzy.fours(oneTimeOfFour);

        //THEN
        assertEquals(expectedForThreeTimes, actualForThreeTimes);
        assertEquals(expectedForTwoTimes, actualForTwoTimes);
        assertEquals(expectedForOneTime, actualForOneTime);
    }
    @Test
    public void foursShouldReturnZeroWhenDiceRollsIsNull() {
        //GIVEN
        int expected = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.fours(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnTheSumOfFivesInDiceRolls() {
        //GIVEN
        DiceRolls twoTimesOfFive = new DiceRolls(4, 4, 4, 5, 5);
        DiceRolls threeTimesOfFive = new DiceRolls(4, 4, 5, 5, 5);
        DiceRolls fourTimesOfFive = new DiceRolls(4, 5, 5, 5, 5);
        int expectedForTwoTimes = 10;
        int expectedForThreeTimes = 15;
        int  expectedForFourTimes  = 20;

        //WHEN
        int actualForTwoTimes = Yatzy.fives(twoTimesOfFive);
        int actualForThreeTimes = Yatzy.fives(threeTimesOfFive);
        int actualForFourTimes = Yatzy.fives(fourTimesOfFive);

        //THEN
        assertEquals(expectedForTwoTimes,actualForTwoTimes);
        assertEquals(expectedForThreeTimes, actualForThreeTimes);
        assertEquals(  expectedForFourTimes, actualForFourTimes);
    }
    @Test
    public void fivesShouldReturnZeroWhenDiceRollsIsNull() {
        //GIVEN
        int expected = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.fives(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnTheSumOfSixesInDiceRolls() {
        //GIVEN
        DiceRolls zeroTimesOfSix = new DiceRolls(4,4,4,5,5);
        DiceRolls oneTimesOfSix = new DiceRolls(4,4,6,5,5);
        DiceRolls threeTimesOfSix = new DiceRolls(6,5,6,6,5);
        int expectedForZeroTime = 0;
        int expectedForOneTime = 6;
        int  expectedForThreeTimes  = 18;

        //WHEN
        int actualForZeroTime = Yatzy.sixes(zeroTimesOfSix);
        int actualForOneTime = Yatzy.sixes(oneTimesOfSix);
        int actualForThreeTimes = Yatzy.sixes(threeTimesOfSix);

        assertEquals(expectedForZeroTime,  actualForZeroTime);
        assertEquals(expectedForOneTime,  actualForOneTime);
        assertEquals(expectedForThreeTimes, actualForThreeTimes);
    }

    @Test
    public void sixesShouldReturnZeroWhenDiceRollsIsNull() {
        //GIVEN
        int expected = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.sixes(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnTheSumOfMaxPair() {
        //GIVEN
        DiceRolls pairOfThree = new DiceRolls(3, 4, 3, 5, 6);
        DiceRolls pairOfFive = new DiceRolls(5, 3, 3, 3, 5);
        DiceRolls pairOfSix = new DiceRolls(5, 3, 6, 6, 5);
        int expectedForPairOfThree = 6;
        int expectedForPairOfFive = 10;
        int expectedForPairOfSix = 12;

        //WHEN
        int actualForPairOfThree = Yatzy.sumMaxPair(pairOfThree);
        int actualForPairOfFive = Yatzy.sumMaxPair(pairOfFive);
        int actualForPairOfSix = Yatzy.sumMaxPair(pairOfSix);

        //THEN
        assertEquals(expectedForPairOfThree, actualForPairOfThree);
        assertEquals(expectedForPairOfFive, actualForPairOfFive);
        assertEquals(expectedForPairOfSix, actualForPairOfSix);

    }
    @Test
    public void sumMaxPairShouldReturnZeroWhenDiceRollsIsNull() {
        //GIVEN
        int expected = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.sumMaxPair(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnSumOfDiceValuesWhenTwoPairInDiceRolls() {
        assertEquals(16, Yatzy.twoPairs(new DiceRolls(3,3,5,4,5)));
        assertEquals(16, Yatzy.twoPairs(new DiceRolls(3,3,5,5,5)));
        assertEquals(14, Yatzy.twoPairs(new DiceRolls(2,2,5,5,5)));
        assertEquals(12, Yatzy.twoPairs(new DiceRolls(1,1,5,5,5)));
    }
    @Test
    public void shouldReturnZeorWhenNotTwoPair() {
        //GIVEN
        DiceRolls diceRolls = new DiceRolls(1, 1, 6, 4, 5);
        int expected = 0;
        //WHEN
        int actual = Yatzy.twoPairs(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeorWhenDiceRollsIsNull() {
        //GIVEN
        int expected = 0;
        DiceRolls diceRolls = null;
        //WHEN
        int actual = Yatzy.twoPairs(diceRolls);
        //THEN
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnSumOfDiceValuesWhenThreeOfAKind()
    {
        //GIVEN
        DiceRolls threeKindOfThree = new DiceRolls(3, 3, 3, 4, 5);
        DiceRolls threeKindOfFive = new DiceRolls(5, 3, 5, 4, 5);
        DiceRolls fourKindOfThree = new DiceRolls(3, 3, 3, 3, 5);
        int expectedForThreeKindOfThree = 9;
        int expectedForThreeKindOfFive = 15;
        int expectedForFourKindOfThree = 9;

        //WHEN
        int actualForThreeKindOfThree = Yatzy.threeOfAKind(threeKindOfThree);
        int actualForThreeKindOfFive = Yatzy.threeOfAKind(threeKindOfFive);
        int actualForFourKindOfThree = Yatzy.threeOfAKind(fourKindOfThree);

        //THEN
        assertEquals(expectedForThreeKindOfThree, actualForThreeKindOfThree);
        assertEquals(expectedForThreeKindOfFive, actualForThreeKindOfFive);
        assertEquals(expectedForFourKindOfThree, actualForFourKindOfThree);
    }

    @Test
    public void shouldReturnZeorWhenNotThreeOfAKind()
    {
        //GIVEN
        DiceRolls diceRollsNull = null;
        DiceRolls diceRolls = new DiceRolls(3, 3, 2, 4, 5);
        int expected = 0;

        //WHEN
        int actual = Yatzy.threeOfAKind(diceRolls);
        int actualForNull = Yatzy.threeOfAKind(diceRollsNull);

        //THEN
        assertEquals(expected, actual);
        assertEquals(expected, actualForNull);
    }

    @Test
    public void shouldReturnSumOfDiceValuesWhenFourOfAKind() {

        //GIVEN
        DiceRolls fourKindOfThree = new DiceRolls(3, 3, 3, 3, 5);
        DiceRolls fourKindOfFive = new DiceRolls(5, 5, 5, 4, 5);
        int expectedForFourKindOfFive = 20;
        int expectedForFourKindOfThree = 12;

        //WHEN
        int actualForFourKindOfFive = Yatzy.fourOfAKind(fourKindOfThree);
        int actualForFourKindOfThree = Yatzy.fourOfAKind(fourKindOfFive);

       //THEN
        assertEquals(expectedForFourKindOfThree, actualForFourKindOfFive);
        assertEquals(expectedForFourKindOfFive, actualForFourKindOfThree);
        assertEquals(9, Yatzy.threeOfAKind(new DiceRolls(3,3,3,3,3)));
    }

    @Test
    public void shouldReturnZeroWhenNotFourOfAKind() {

        //GIVEN
        DiceRolls diceRollsNull = null;
        DiceRolls diceRolls = new DiceRolls(3,3,2,3,5);
        int expected = 0;

        //WHEN
        int actual = Yatzy.fourOfAKind(diceRolls);
        int actualForNull = Yatzy.fourOfAKind(diceRollsNull);

        //THEN
        assertEquals(expected, actual);
        assertEquals(expected, actualForNull);
    }

    @Test
    public void shouldRetrunFifteenWhenSmallStraight() {
        //GIVE
        DiceRolls orderedSmallStraight = new DiceRolls(1, 2, 3, 4, 5);
        DiceRolls disorderedSmallStraight = new DiceRolls(2, 3, 4, 5, 1);
        int expectedForOrderedSmallStraight = 15;
        int expectedForDisorderedSmallStraight = 15;
        //WHEN
        int actualForOrderedSmallStraight = Yatzy.smallStraight(orderedSmallStraight);
        int actualForDisorderedSmallStraight = Yatzy.smallStraight(disorderedSmallStraight);

        //THEN
        assertEquals(expectedForOrderedSmallStraight, actualForOrderedSmallStraight);
        assertEquals(expectedForDisorderedSmallStraight, actualForDisorderedSmallStraight);
    }

    @Test
    public void shouldReturnZeroWhenNotSmallStraight() {
        //GIVEN
        DiceRolls diceRollsNull = null;
        DiceRolls diceRolls = new DiceRolls(1,2,2,4,5);
        int expected = 0;

        //WHEN
        int actual = Yatzy.smallStraight(diceRolls);
        int actualForNull = Yatzy.smallStraight(diceRollsNull);

        //THEN
        assertEquals(expected, actual);
        assertEquals(expected, actualForNull);
    }

    @Test
    public void shouldReturnTwentyWhenLargeStraight() {
        //GIVEN
        DiceRolls disorderedLargeStraight = new DiceRolls(6,2,3,4,5);
        DiceRolls  orderedLargeStraight = new DiceRolls(2,3,4,5,6);
        int expectedForOrderedLargeStraight = 20;
        int expectedForDisorderedLargeStraight = 20;
        //WHEN
        int actualForOrderedSmallStraight = Yatzy.largeStraight(orderedLargeStraight);
        int actualForDisorderedSmallStraight = Yatzy.largeStraight(disorderedLargeStraight);

        //THEN
        assertEquals(expectedForOrderedLargeStraight, actualForOrderedSmallStraight);
        assertEquals(expectedForDisorderedLargeStraight, actualForDisorderedSmallStraight);
    }
    @Test
    public void shouldReturnZeroWhenNotLargeStraight() {
        //GIVEN
        DiceRolls diceRollsNull = null;
        DiceRolls diceRolls = new DiceRolls(1,2,2,4,5);
        int expected = 0;

        //WHEN
        int actual = Yatzy.largeStraight(diceRolls);
        int actualForNull = Yatzy.largeStraight(diceRollsNull);

        //THEN
        assertEquals(expected, actual);
        assertEquals(expected, actualForNull);
    }

    @Test
    public void shouldReturnTheSumOfDiceRollsWhenFullHouse() {

       //THEN
        DiceRolls fullHouse = new DiceRolls(6, 2, 2, 2, 6);
        int expected = 18;

        //WHEN
        int actual = Yatzy.fullHouse(fullHouse);

        //THEN
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnZerorWhenNotFullHouse() {
        //GIVEN
        DiceRolls diceRollsNull = null;
        DiceRolls diceRolls = new DiceRolls(2,3,4,5,6);
        int expected = 0;

        //WHEN
        int actual = Yatzy.fullHouse(diceRolls);
        int actualForNull = Yatzy.fullHouse(diceRollsNull);

        //THEN
        assertEquals(expected, actual);
        assertEquals(expected, actualForNull);
    }
}
