package labor14_1;

public class Phone extends  Device{

    private boolean sim;

    public Phone(String opSystem, boolean sim) {
        super(opSystem);
        this.sim = sim;
    }

    public boolean isSim() {
        return sim;
    }

    public void setSim(boolean sim) {
        this.sim = sim;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "sim=" + sim +
                "} " + super.toString();
    }
}
