public class LastNames implements Names{

    private String[] names;

    public LastNames(String... args){
        this.names = args;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(String s : names){
            sb.append(s + " ");
        }
        return sb.toString();
    }

    @Override
    public String[] collection() {
        return names;
    }
}
