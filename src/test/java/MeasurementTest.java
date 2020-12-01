import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasurementTest {

    @Test
    public void checkMeasurementImplementors(){
        Measurement m = new HeightMeasurement(198.5, LocalDate.of(2020,10,21));
        Measurement m2 = new HeightMeasurement(200.4);
        assertEquals(198.5, m.measurement());
        assert(LocalDate.of(2020,10,21).isEqual(m.dateOfMeasurement()));
        assert(LocalDate.now().isEqual(m2.dateOfMeasurement()));
    }
}
