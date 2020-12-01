public class StrictPerson implements DefaultPerson{


    private final DefaultPerson origin;


    public StrictPerson(DefaultPerson person){
        this.origin = person;
    }


    @Override
    public void anotherMeasurement(Measurement measurement) {
        if(measurement.measurement() == 0.0 || measurement.dateOfMeasurement() == null){
            throw new IllegalArgumentException("The measurement given was: " + measurement.measurement() + " and the date was: " + measurement.dateOfMeasurement());
        }
        this.origin.anotherMeasurement(measurement);
    }

    @Override
    public String toString(){
       return this.origin.toString();
    }
}
