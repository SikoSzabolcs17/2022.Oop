import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] generateRandomNumbers(int number){
        Random rand = new Random();

        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = rand.nextInt(number); // hatar legyen a darabszam de nemmuszaj ide parametert
        }
        return array;
    }

    public static void printNumberofDuplicates(int[] array){
        Arrays.sort(array);


        int counter = 0;

        for (int i = 1; i < array.length; i++) {
            if(array[i-1]==array[i]) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
