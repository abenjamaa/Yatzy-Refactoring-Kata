import java.util.*;
import java.util.stream.Collectors;

public class DiceRolls {

        private final List<Integer> dice;
    public DiceRolls() {
        this.dice = List.of();
    }
    public DiceRolls(int d1, int d2, int d3, int d4, int d5) {
        this.dice = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int getCountOf(int diceFaceNumber){
        return (int) dice.stream()
            .filter(d -> d == diceFaceNumber)
            .count();
    }

    public int sum(){
        return dice.stream().reduce(0, Integer::sum);
    }

    public boolean isSameDiceRollFiveTimes() {
        return groupRollsByRollResults().values().stream().anyMatch(d -> d == 5);
    }
    public int maxPairValue() {
        return groupRollsByRollResults()
            .entrySet()
            .stream()
            .filter(Objects::nonNull)
            .filter(map -> map.getValue() > 1)
            .max(Comparator.comparingInt(Map.Entry::getKey))
            .map(Map.Entry::getKey)
            .orElse(0);
    }

    public int computeDiceFaceValueMultipliedByDiceFaceValueCount(int diceFaceValue) {
        return getCountOf(diceFaceValue) * diceFaceValue;
    }

    public List<Integer> getDiceValuesWithCountEqualTo(int count) {
       return groupRollsByRollResults()
            .entrySet()
            .stream()
            .filter(Objects::nonNull)
            .filter(map -> map.getValue() >= count )
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public int isYatzy() {
        return isSameDiceRollFiveTimes() ? 50 : 0;
    }

    private Map<Integer, Long> groupRollsByRollResults() {
        return dice.stream()
            .collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }


}