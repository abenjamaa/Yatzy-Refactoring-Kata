import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiceRoll {

        private final List<Integer> dice;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = Arrays.asList(d1, d2, d3, d4, d5);
    }
    public DiceRoll(int[] dice) {
        this.dice = Arrays.stream(dice).boxed().collect(Collectors.toList());
    }

    public int getOccurrenceOf(int diceFaceNumber){
        return (int) dice.stream()
            .filter(d -> d == diceFaceNumber)
            .count();
    }

    public int sum(){
        return dice.stream().reduce(0, Integer::sum);
    }

    public boolean isYatzy() {
        return groupRollsByResult().values().stream().anyMatch(d -> d == 5);
    }

    private  Map<Integer, Long> groupRollsByResult() {
        return dice.stream()
            .collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }
}
