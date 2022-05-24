package labor14_1;

import java.util.Objects;

public class Device {
    private String opSystem;
    private int iP;

    private static int counter = -1;

    public Device(String opSystem) {
        this.opSystem = opSystem;
        ++counter;
        this.iP = counter;
    }

    public String getOpSystem() {
        return opSystem;
    }

    public void setOpSystem(String opSystem) {
        this.opSystem = opSystem;
    }

    public void setiP(int iP) {
        this.iP = iP;
    }

    public int getiP() {
        return iP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return iP == device.iP && Objects.equals(opSystem, device.opSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opSystem, iP);
    }

    @Override
    public String toString() {
        return "Device{" +
                "opSystem='" + opSystem + '\'' +
                ", iP=" + iP +
                '}';
    }
}
