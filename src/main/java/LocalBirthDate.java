import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalBirthDate implements BirthDate{

    private LocalDateTime birthDate;

    private LocalDate bDate;

    private LocalTime bTime;

    public LocalBirthDate(LocalDateTime birthDate){
        this.birthDate = birthDate;
    }


    @Override
    public LocalDate date() {
        if(this.bDate == null){
            this.bDate = this.birthDate.toLocalDate();
        }
        return this.bDate;
    }

    @Override
    public LocalTime time() {
        if(this.bTime == null) {
            this.bTime = this.birthDate.toLocalTime();
        }
        return this.bTime;
    }
}
