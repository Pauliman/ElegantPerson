public enum Sex {

    MALE("männlich"),
    FEMALE("weiblich"),
    DIVERSE("divers");

    public String label;

    private Sex(String label){
        this.label = label;
    }


}
