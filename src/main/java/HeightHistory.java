import java.time.LocalDate;
import java.util.List;

/**
 * This interface provides builder methods which offer four different ways to get a specific measurement.
 */
public interface HeightHistory {

    /**
     * @return the first measurement that was ever associated with the person.
     */
    public double firstMeasurement();

    /**
     * @return the last measurement currently available for this person. Can be the same as the first
     */
    public double lastMeasurement();

    /**
     * Offers to find a measurement that was taken on a specific day.
     * @param dateOfMeasurement The day of the measurement
     * @return the value of the measurement, if any
     */
    public double measurementOn(LocalDate dateOfMeasurement);

    /**
     * A full take.
     * @return a list of all available measurements and the dates encapsulated in Measurment objects.
     */
    public List<Measurement> allMeasurements();
}
