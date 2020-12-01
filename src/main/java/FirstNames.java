public class FirstNames implements Names{

    private String[] names;

    public FirstNames(String... args){
        this.names = args;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(String s : names){
            sb.append(s + " ");
        }
        return sb.toString().trim();
    }

    @Override
    public String[] collection() {
        return this.names;
    }
}
