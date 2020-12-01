public class NewLineString {

    private String string;

    public NewLineString(String string){
       this.string = string;
    }

    @Override
    public String toString(){
        return this.string + System.lineSeparator();
    }
}
