package Leo;

import java.util.Arrays;
import java.util.HashSet;

public class DemoCode {
    public static void main(String[] args) {
        String[] arr = {"volvo", "Jeep","Jeep"};
        HashSet<String> cars = new HashSet<String>(Arrays.asList(arr));

        cars.forEach( n -> System.out.println(n) );

    }
}
