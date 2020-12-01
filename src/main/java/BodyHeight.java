import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class BodyHeight implements HeightHistory, MeasuringEvent {

    /**
     * This list object won't change but the values inside may, that is why it can be made final.
     */
    private final List<Measurement> listOfMeasurements;

    public BodyHeight() {
        this.listOfMeasurements = new ArrayList<>();
    }
    public BodyHeight(Measurement measurement){
        this();
        this.listOfMeasurements.add(measurement);
    }

    @Override
    public void anotherMeasurement(Measurement measurement){
        this.listOfMeasurements.add(measurement);
    }

    @Override
    public double firstMeasurement() {
        return this.measurement(true);
    }

    @Override
    public double lastMeasurement() {
      return this.measurement(false);
    }

    @Override
    public double measurementOn(LocalDate dateOfMeasurement) {
        double returnValue = 0.0;
        if(this.listOfMeasurements.isEmpty()){
            return returnValue;
        }
        for(Measurement m : this.listOfMeasurements){
            if(dateOfMeasurement.equals(m.dateOfMeasurement()))
                returnValue = m.measurement();
        }
        return returnValue;
    }

    @Override
    public List<Measurement> allMeasurements() {
        return this.listOfMeasurements;
    }

    /**
     * Object internal builder method.
     * @param isFirst if true the first measurement is returned, if false the last one.
     * @return The measurement requested as primitive double value.
     */
    private double measurement(boolean isFirst){
        if(!this.listOfMeasurements.isEmpty()){
            if(isFirst) {
                return this.listOfMeasurements.get(0).measurement();
            } else {
                int lastIndex = this.listOfMeasurements.size() -1;
                return this.listOfMeasurements.get(lastIndex).measurement();
            }
        } else {
            return 0.0;
        }
    }
}
