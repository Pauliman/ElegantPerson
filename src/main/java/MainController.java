import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainController {

    public static void main(String[] args){
        LocalDate ld = LocalDate.of(1999,9,3);
        Person p1 = new Person(LocalDateTime.of(LocalDate.of(1966,3,22), LocalTime.of(03,25,30)),
                Sex.MALE,
                new HeightMeasurement(39.0, LocalDate.of(1956,8,12)),
                new FirstNames("Carlos", "Julio"),
                new LastNames("Mendoza", "Gonzales"));
        DefaultPerson p2 = new StrictPerson(new Person("1965.11.22T03:25:30Z",
                Sex.MALE,
                new HeightMeasurement(38.5, LocalDate.of(1965,11,22)),
                new FirstNames("Hans", "Dieter"),
                new LastNames("Müller")));
        p2.anotherMeasurement(new HeightMeasurement(183,ld));
        System.out.println(p1);
        System.out.println(p2);
    }
}
