package labor14_1;

public class Computer extends Device {
    private double hdSize;

    public Computer(String opSystem, Double hdSize) {
        super(opSystem);
        this.hdSize = hdSize;
    }

    public double getHdSize() {
        return hdSize;
    }

    public void setHdSize(double hdSize) {
        this.hdSize = hdSize;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "hdSize=" + hdSize +
                "} " + super.toString();
    }
}
