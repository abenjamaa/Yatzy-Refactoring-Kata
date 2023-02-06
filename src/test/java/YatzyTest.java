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

        //WHEN

        //THEN
        assertEquals(1, Yatzy.ones(new DiceRolls(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new DiceRolls(1,2,1,4,5)));
        assertEquals(0, Yatzy.ones(new DiceRolls(6,2,2,4,5)));
        assertEquals(4, Yatzy.ones(new DiceRolls(1,2,1,1,1)));
        assertEquals(0, Yatzy.ones(null));
    }

    @Test
    public void shouldReturnTheSumOfTwosInDiceRolls() {
        //GIVEN

        //WHEN

        //THEN
        assertEquals(4, Yatzy.twos(new DiceRolls(1,2,3,2,6)));
        assertEquals(10, Yatzy.twos(new DiceRolls(2,2,2,2,2)));
        assertEquals(0, Yatzy.twos(null));
    }

    @Test
    public void shouldReturnTheSumOfThreesInDiceRolls() {
        //GIVEN

        //WHEN

        //THEN
        assertEquals(6, Yatzy.threes(new DiceRolls(1,2,3,2,3)));
        assertEquals(12, Yatzy.threes(new DiceRolls(2,3,3,3,3)));
        assertEquals(0, Yatzy.threes(null));
    }

    @Test
    public void shouldReturnTheSumOfFoursInDiceRolls()
    {
        //GIVEN

        //WHEN

        //THEN
        assertEquals(12, Yatzy.fours(new DiceRolls(4,4,4,5,5)));
        assertEquals(8, Yatzy.fours(new DiceRolls(4,4,5,5,5)));
        assertEquals(4, Yatzy.fours(new DiceRolls(4,5,5,5,5)));
        assertEquals(0, Yatzy.fours(null));
    }

    @Test
    public void shouldReturnTheSumOfFivesInDiceRolls() {
        //GIVEN

        //WHEN

        //THEN
        assertEquals(10,  Yatzy.fives(new DiceRolls(4,4,4,5,5)));
        assertEquals(15,  Yatzy.fives(new DiceRolls(4,4,5,5,5)));
        assertEquals(20,  Yatzy.fives(new DiceRolls(4,5,5,5,5)));
        assertEquals(0, Yatzy.fives(null));
    }

    @Test
    public void shouldReturnTheSumOfSixesInDiceRolls() {
        //GIVEN

        //WHEN

        //THEN
        assertEquals(0,  Yatzy.sixes(new DiceRolls(4,4,4,5,5)));
        assertEquals(6,  Yatzy.sixes(new DiceRolls(4,4,6,5,5)));
        assertEquals(18, Yatzy.sixes(new DiceRolls(6,5,6,6,5)));
        assertEquals(0, Yatzy.sixes(null));
    }

    @Test
    public void shouldReturnTheSumOfMaxPair() {
        //GIVEN

        //WHEN

        //THEN
        assertEquals(6, Yatzy.sumMaxPair(new DiceRolls(3,4,3,5,6)));
        assertEquals(10, Yatzy.sumMaxPair(new DiceRolls(5,3,3,3,5)));
        assertEquals(12, Yatzy.sumMaxPair(new DiceRolls(5,3,6,6,5)));
        assertEquals(12, Yatzy.sumMaxPair(new DiceRolls(5,3,6,6,5)));
        assertEquals(0, Yatzy.sumMaxPair(null));
    }

    @Test
    public void shouldReturnSumOfDiceValuesWhenTwoPairInDiceRolls() {
        //GIVEN

        //WHEN

        //THEN
        assertEquals(16, Yatzy.twoPairs(new DiceRolls(3,3,5,4,5)));
        assertEquals(16, Yatzy.twoPairs(new DiceRolls(3,3,5,5,5)));
        assertEquals(14, Yatzy.twoPairs(new DiceRolls(2,2,5,5,5)));
        assertEquals(12, Yatzy.twoPairs(new DiceRolls(1,1,5,5,5)));
    }
    @Test
    public void shouldReturnZeorWhenNotTwoPair() {
        //GIVEN

        //WHEN

        //THE
        assertEquals(0, Yatzy.twoPairs(new DiceRolls(1,1,6,4,5)));
        assertEquals(0, Yatzy.twoPairs(null));
    }
    @Test
    public void shouldReturnSumOfDiceValuesWhenThreeOfAKind()
    {
        assertEquals(9, Yatzy.threeOfAKind(new DiceRolls(3,3,3,4,5)));
        assertEquals(15, Yatzy.threeOfAKind(new DiceRolls(5,3,5,4,5)));
        assertEquals(9, Yatzy.threeOfAKind(new DiceRolls(3,3,3,3,5)));
    }

    @Test
    public void shouldReturnZeorWhenNotThreeOfAKind()
    {
        assertEquals(0, Yatzy.threeOfAKind(new DiceRolls(3,3,2,4,5)));
        assertEquals(0, Yatzy.threeOfAKind(null));
    }

    @Test
    public void shouldReturnSumOfDiceValuesWhenFourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(new DiceRolls(3,3,3,3,5)));
        assertEquals(20, Yatzy.fourOfAKind(new DiceRolls(5,5,5,4,5)));
        assertEquals(9, Yatzy.threeOfAKind(new DiceRolls(3,3,3,3,3)));
    }

    @Test
    public void shouldReturnZeroWhenNotFourOfAKind() {
        assertEquals(0, Yatzy.fourOfAKind(new DiceRolls(3,3,2,3,5)));
        assertEquals(0, Yatzy.fourOfAKind(null));
    }

    @Test
    public void shouldRetrunFifteenWhenSmallStraight() {
        assertEquals(15, Yatzy.smallStraight(new DiceRolls(1,2,3,4,5)));
        assertEquals(15, Yatzy.smallStraight(new DiceRolls(2,3,4,5,1)));
    }

    @Test
    public void shouldRetrunZeorWhenNotSmallStraight() {
        assertEquals(0, Yatzy.smallStraight(new DiceRolls(1,2,2,4,5)));
        assertEquals(0, Yatzy.smallStraight(null));
    }

    @Test
    public void shouldReturnTwentyWhenLargeStraight() {
        assertEquals(20, Yatzy.largeStraight(new DiceRolls(6,2,3,4,5)));
        assertEquals(20, Yatzy.largeStraight(new DiceRolls(2,3,4,5,6)));
    }
    @Test
    public void shouldReturnZeorWhenNotLargeStraight() {
        assertEquals(0, Yatzy.largeStraight(new DiceRolls(1,2,2,4,5)));
        assertEquals(0, Yatzy.largeStraight(null));
    }

    @Test
    public void shouldReturnTheSumOfDiceRollsWhenFullHouse() {
        assertEquals(18, Yatzy.fullHouse(new DiceRolls(6,2,2,2,6)));
        assertEquals(16, Yatzy.fullHouse(new DiceRolls(5,2,2,2,5)));
    }
    @Test
    public void shouldReturnZerorWhenNotFullHouse() {
        assertEquals(0, Yatzy.fullHouse(new DiceRolls(2,3,4,5,6)));
        assertEquals(0, Yatzy.fullHouse(new DiceRolls(2,2,2,4,5)));
        assertEquals(0, Yatzy.fullHouse(new DiceRolls(2,2,6,6,5)));
        assertEquals(0, Yatzy.fullHouse(new DiceRolls(2,2,2,2,2)));
        assertEquals(0, Yatzy.fullHouse(null));
    }
}
