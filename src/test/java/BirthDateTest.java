import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BirthDateTest {

    @Test
    public void checkBirthDateImplementors(){
        BirthDate lbd = new LocalBirthDate(LocalDateTime.of(2020,11,23,23,22,00));
        BirthDate sbd = new StringBirthDate("2020.11.23T23:22:00Z");
        assert(lbd.time() instanceof LocalTime);
        assert(lbd.date() instanceof LocalDate);
        assert(sbd.date() instanceof LocalDate);
        assert(sbd.time() instanceof LocalTime);
        assert(lbd.date().isEqual(sbd.date()));
        Assertions.assertEquals(0, lbd.time().compareTo(sbd.time()));
    }

    @Test
    public void fakeBirthDate(){
        BirthDate bd = new BirthDate.Fake();
        assert(bd.date().isEqual(LocalDate.of(1976,12,4)));
        Assertions.assertEquals(0,bd.time().compareTo(LocalTime.of(12,30,00)));

    }
}
