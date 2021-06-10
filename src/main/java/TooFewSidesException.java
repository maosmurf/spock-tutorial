public class TooFewSidesException extends IllegalArgumentException {
    private final int numberOfSides;

    /**
     * Constructs an {@code IllegalArgumentException} with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public TooFewSidesException(String s, int numberOfSides) {
        super(s);
        this.numberOfSides = numberOfSides;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }
}
