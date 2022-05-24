package labor14_1;

import java.util.ArrayList;
import java.util.Comparator;

public class Network {
    private ArrayList<Device>devices = new ArrayList<>();

    private Comparator<Device>comparator = new Comparator<Device>() {
        @Override
        public int compare(Device o1, Device o2) {
            if(o1.getClass() == o2.getClass()){

                if(o1.getClass() == Phone.class){
                    return o1.getOpSystem().compareTo(o2.getOpSystem());
                }
                if(o1.getClass() == Computer.class){
                    return Double.compare(((Computer)o1).getHdSize(),((Computer)o2).getHdSize());
                }

            }
            else if(o1.getClass() == Phone.class){
                return -1;
            }
            else{
                return 1;
            }
            return 0;
        }
    };

    public boolean isFull(){
        if(devices.size()<255){
            return false;
        }
        return true;
    }

    public void connect(Device device){
        if(!isFull()){
            devices.add(device);
        }
    }
    public void deConnect(Device device){

        for (int i = 0; i < devices.size(); i++) {
            if(devices.get(i).equals(device)){
                device.setiP(-1);
                devices.remove(i);
                return;
            }
        }
    }
    public void printDevices(){
        for (Device device:devices){
            System.out.println(device);
        }
        System.out.println();
    }
    public void printPhones(){
        for (Device device:devices){
            if(device.getClass() == Phone.class){
                System.out.println(device);
            }
        }
        System.out.println();
    }
    public void sortDevices(){
        devices.sort(comparator);
    }
}
