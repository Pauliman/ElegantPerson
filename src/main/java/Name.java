import java.util.List;

public class Name {
    private FirstNames christianNames; // there can be more than one first name
    private LastNames familyNames;  // there can be more than one family name

    public Name(FirstNames fn, LastNames ln){
        this.christianNames = fn;
        this.familyNames = ln;
    }

    public String oneString(){
        return this.christianNames.toString() + " " + this.familyNames.toString();
    }
}
