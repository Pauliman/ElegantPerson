import java.time.LocalDate;

/**
 * The object that agrees to the contract of Measurement
 */
public class HeightMeasurement implements Measurement {

    /**
     * Eventhough it is called currentHeight, it never changes and thus should be final.
     */
    private final double currentHeight;

    /**
     * The date of the measurement must be preserved and must be final
     */
    private final LocalDate date;

    /**
     * The secondary constructor allows more flexibility as no date argument is required.
     * @param currentHeight
     */
    public HeightMeasurement(double currentHeight){
        this(currentHeight , LocalDate.now());
    }

    /**
     * Primary constructor that receives a default LocalDate object from the secondary constructor in case no date was specified.
     * @param currentHeight
     * @param date
     */
    public HeightMeasurement(double currentHeight, LocalDate date){
        this.currentHeight = currentHeight;
        this.date = date;
    }

    @Override
    public double measurement() {
        return this.currentHeight;
    }

    @Override
    public LocalDate dateOfMeasurement() {
        return this.date;
    }
}
