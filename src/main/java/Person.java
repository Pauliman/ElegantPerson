import java.time.LocalDate;
import java.time.LocalDateTime;


public class Person implements DefaultPerson{
    /**
     * The date of birth defines the official start of the existence of a human being, so it is predestined to be set
     * in the constructor of a Person object. A person without a d.o.b does not exist, though some nations care less about the date than others.
     * The d.o.b is encapsulated in objects that implement the BirthDate interface,
     * so it is possible to offer different formats that can be used as constructor arguments to set the birthday.
     * Whatever the input, BirthDate will be able to return either a LocalDate or a LocalTime object.
     * This object is final as it is only set once for this object an has no reason to change.
     */
    private final BirthDate dayOfBirth;

    /**
     * The sex of a person is usually determined at birth and thus can be set in the constructor. The ENUM type
     * is an appropriate solution as it is constant yet open for change, since in a some rare
     * cases the sex of a person may change.
     */
    private Sex sex;

    /**
     * Even though body height seems a simple thing, it is a fluctuating value. Persons display different heights at different
     * ages. To represent this an encapsulating data type is required that allows the storage of many measurement-date pairs.
     * These pairs come in the shape of a HeightMeasurement object, while the collection for them is provided by the BodyHeight
     * object that implements the HeightHistory interface and thus providing methods for convenient retrieval of the measurements.
     */
    private final BodyHeight bodyHeight;

    /**
     * Name is also quite a complex issue if you want to create a solution for people from all over the world. Not only can
     * first names be more that one, in some countries there are at least two last names representing father and mother.
     */
    private final Name name;

    /**
     * According to the rule of elegant objects, no logic is allowed in a constructor.
     * Since the date of birth is the only primitive value that is passed into the constructor, the latter has been overloaded to accommodate
     * a LocalDateTime object and a String representation of a birth date. The two respective object types implement the BirthDate
     * interface and behave alike when called.
     * @param dayOfBirth LocalDateTime which is encapsulated by LocalBirthDate class which implements the interface BirthDate
     * @param sex an ENUM type
     * @param heightMeasurement of type HeightMeasurement is a wrapper implementing the interface Measurement
     * @param firstNames FirstNames is a wrapper including a collection of string values
     * @param lastNames LastNames is also a collection of strings
     */
    public Person (LocalDateTime dayOfBirth, Sex sex, HeightMeasurement heightMeasurement, FirstNames firstNames, LastNames lastNames ){
      this(new LocalBirthDate(dayOfBirth), sex, heightMeasurement, firstNames, lastNames);
    }

    /**
     * see above
     */
    public Person (String dayOfBirth, Sex sex, HeightMeasurement heightMeasurement, FirstNames firstNames, LastNames lastNames ){
        this(new StringBirthDate(dayOfBirth), sex, heightMeasurement,firstNames, lastNames);
    }

    /**
     * This is the primary constructor that all other constructors feed their data into.
     * @param dayOfBirth Although no constructor exists that offers BirthDate to the outside, the primary constructor receives
     *                   a modified input argument which was prepared in the calling constructor.
     * @param sex an ENUM type
     * @param heightMeasurement of type HeightMeasurement is a wrapper implementing the interface Measurement
     * @param firstNames FirstNames is a wrapper including a collection of string values
     * @param lastNames LastNames is also a collection of strings
     */
    public Person (BirthDate dayOfBirth, Sex sex, HeightMeasurement heightMeasurement, FirstNames firstNames, LastNames lastNames){
        this.dayOfBirth = dayOfBirth;
        this.sex = sex;
        this.bodyHeight = new BodyHeight(heightMeasurement);
        this.name = new Name(firstNames, lastNames);
    }

    /**
     * Inherited form Object and always a good idea to override, as it comes conveniently when a look into the object is required.
     * As one overrides this method so every method should override a method preferably one declared by an interface.
     * @return
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(new NewLineString("Name: " + this.name.oneString()));
        sb.append(new NewLineString("Geburtsdatum: " + this.dayOfBirth.date().toString() + " Uhrzeit: " + this.dayOfBirth.time().toString()));
        for (Measurement m : this.bodyHeight.allMeasurements()){
            sb.append(new NewLineString("Köpergröße am: " + m.dateOfMeasurement() + " = " + m.measurement()));
        }
        sb.append(new NewLineString("Geschlecht: " + sex.label + System.lineSeparator()));
        return sb.toString();
    }


    @Override
    public void anotherMeasurement(Measurement measurement) {
        this.bodyHeight.anotherMeasurement(measurement);
    }
}
