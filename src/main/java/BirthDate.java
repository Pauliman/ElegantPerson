import java.time.LocalDate;

import java.time.LocalTime;

/**
 * Provides a contract for an object that wants to act as a BirthDate.
 */
public interface BirthDate {

    /**
     * This return the date segment of a birth date.
     * @return Java8 Time API type of a date object
     */
    public abstract LocalDate date();

    /**
     * This returns the time segment of a birth date.
     * @return Java8 Time API type of a time object
     */
    public abstract LocalTime time();


    /**
     * This final inner class can be used instead of mocking. Just create an Object of type BirthDate bd = new BirthDate.Fake().
     */

    final class Fake implements BirthDate {


        @Override
        public LocalDate date() {
            return LocalDate.of(1976,12,04);
        }

        @Override
        public LocalTime time() {
            return LocalTime.of(12,30,00);
        }
    }
}
