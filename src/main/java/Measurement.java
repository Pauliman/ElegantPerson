import java.time.LocalDate;

/**
 * The measurement interface holds the contract for any measurement object and requires that a value and a date must be provided.
 */
public interface Measurement {

    /**
     * Holds the measurement in floating point style.
     * @return primitive double value
     */
    public abstract double measurement();

    /**
     * Holds the date when the above measurement was taken.
     * @return Java8 Time API local date object
     */
    public abstract LocalDate dateOfMeasurement();
}
