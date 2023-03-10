public enum DiceValueOccurrence {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);
    private final int value;

    /**
     * private contructor
     */
    DiceValueOccurrence(int value) {

        this.value = value;
    }

    /**
     * return value
     */
    public int getValue(){
        return value;
    }
}
