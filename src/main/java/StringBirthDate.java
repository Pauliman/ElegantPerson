import java.time.LocalDate;
import java.time.LocalTime;

public class StringBirthDate implements BirthDate {

    /**
     * A string representation of a birth date. It must be transformed before adheres to the contract of the Birthdate interface.
     */
    private final String birthDate;

    /**
     * This is a cached value that can not be set during instantiation and thus can not be final.
     */
    private LocalDate cachedBirthDate;

    /**
     * This is a cached value that can not be set during instantiation and thus can not be final.
     */
    private LocalTime cachedBirthTime;

    /**
     * Minimum constructor accepting the date as a string of form: "YYYY.MM.DDTHH:mm:ssZ"
     * @param birthDate
     */
    public StringBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public LocalDate date() {
        if(this.cachedBirthDate == null)
            this.cachedBirthDate = this.localDateFromString();
        return this.cachedBirthDate;
    }

    /**
     * Object internal builder method.
     * @return A LocalDate object derived from the string instance field.
     */
    private LocalDate localDateFromString() {
        String year, month, day = null;
        year = this.birthDate.substring(0,4);
        month = this.birthDate.substring(5,7);
        day = this.birthDate.substring(8,10);
        return LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
    }

    @Override
    public LocalTime time() {
        if(this.cachedBirthTime == null)
            this.cachedBirthTime = this.localTimeFromString();
        return this.cachedBirthTime;
    }

    /**
     * Object internal builder method.
     * @return A LocalTime object derived from the string instance field.
     */
    private LocalTime localTimeFromString() {
        String hour, minute, second = null;
        int index = this.birthDate.indexOf("T");
        String timeString = this.birthDate.substring(index + 1);
        if(timeString.length() == 9) {
            hour = timeString.substring(0, 2);
            minute = timeString.substring(3, 5);
            second = timeString.substring(6, 8);
            return LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second));
        }
        return LocalTime.MIDNIGHT;
    }
}
