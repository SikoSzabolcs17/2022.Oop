package labor14_1;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Phone phone1 = new Phone("Android",true);
        Phone phone2 = new Phone("Android",true);
        Phone phone3 = new Phone("iOS",true);

        Computer computer1 = new Computer("Windows",1024.0);
        Computer computer2 = new Computer("MacOs",4242.2);
        Computer computer3 = new Computer("Windows",512.0);

        network.connect(phone1);
        network.connect(phone2);
        network.connect(phone3);

        network.connect(computer1);
        network.connect(computer2);
        network.connect(computer3);

        network.printDevices();

        network.printPhones();

        network.sortDevices();

        network.printDevices();
    }
}
