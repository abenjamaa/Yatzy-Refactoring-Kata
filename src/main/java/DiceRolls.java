import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a Dice Rolls.
 */
public class DiceRolls {

    private final List<Integer> dice;

    /**
     * Construct a DiceRolls with empty list
     */
    public DiceRolls() {
        this.dice = List.of();
    }

    /**
     * Construct a DiceRolls with values
     * @param diceOne the value of dice one
     * @param diceTwo the value of dice two
     * @param diceThree the value of dice three
     * @param diceFour the value of dice four
     * @param dDiceFive the value of dice five
     */
    public DiceRolls(int diceOne, int diceTwo, int diceThree, int diceFour, int dDiceFive) {
        this.dice = Arrays.asList(diceOne, diceTwo, diceThree, diceFour, dDiceFive);
    }

    /**
     * Count the number of occurrences of a diceValue in a DiceRoll
     * @param diceValue the dice number to check
     */
    public int getCountOf(int diceValue){
        return (int) dice.stream()
            .filter(d -> d == diceValue)
            .count();
    }


    /**
     * compute the sum of diceRolls
     */
    public int sum(){
        return dice
            .stream()
            .reduce(0, Integer::sum);
    }

    /**
     * check if is the same dice roll five times
     */
    public boolean isSameDiceRollFiveTimes() {
        return diceValuesCount().values().stream().anyMatch(d -> d == 5);
    }

    /**
     * get the max pair value
     */
    public int maxPairValue() {
        return diceValuesCount()
            .entrySet()
            .stream()
            .filter(Objects::nonNull)
            .filter(map -> map.getValue() > 1)
            .max(Comparator.comparingInt(Map.Entry::getKey))
            .map(Map.Entry::getKey)
            .orElse(0);
    }

    /**
     * Compute dice face value multiplied by dice value count
     * @param diceValue to compute
     */
    public int computeDiceValueMultipliedByOccurrenceCount(int diceValue) {
        return getCountOf(diceValue) * diceValue;
    }


    /**
     * check if is Yatzy
     */
    public int yatzy() {
        return isSameDiceRollFiveTimes() ? 50 : 0;
    }

    /**
     * Compute the sum of dice values whose number of occurrences is equal to count
     * @param count number of occurrences
     */
    public int sumOfDiceValuesWithCountEqualTo(int count){
        return getDiceValuesWithCountEqualTo(count)
            .stream()
            .reduce(0, Integer::sum);
    }
    /**
     * Compute the sum of dice values of two pairs if exists
     * @param count number of occurrences
     */
    public int getSumOfTwoPairs(int count){
        List<Integer> diceValues = getDiceValuesWithCountEqualTo(count);
        return diceValues.size() > 1 ?
            diceValues.stream()
            .reduce(0, Integer::sum) : 0;
    }
    /**
     * Check if Dice rolls is fullhouse
     */
    public boolean isFullHouse(){
        List<Integer> pair = getDiceValuesWithCountEqualTo(2);
        List<Integer> threeKind = getDiceValuesWithCountEqualTo(3);
        return pair.size() > 1 && threeKind.size() > 0 && pair.contains(threeKind.stream().findFirst().orElse(0));
    }


    /**
     * transform to TreeSet of Integer
     */
    public TreeSet<Integer> toTreeSet(){
        return new TreeSet<>(dice);
    }


    /**
     * Grouping diceRolls in a map  <Key>dice value</Key> and <value>count</value>
     */
    private Map<Integer, Long> diceValuesCount() {
        return dice.stream()
            .collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }

    /**
     * get a list of dice values whose occurrences is equal to count
     * @param count number of occurrences
     */
    private List<Integer> getDiceValuesWithCountEqualTo(int count) {
        return diceValuesCount()
            .entrySet()
            .stream()
            .filter(Objects::nonNull)
            .filter(map -> map.getValue() >= count )
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
