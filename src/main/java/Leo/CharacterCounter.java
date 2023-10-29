package Leo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CharacterCounter {
    public static void main(String[] args){
        String input = "richard";
        Map<Character, Integer> charMap = new ConcurrentHashMap<>();
        for(int i = 0; i < input.length(); i++){
            charMap.put(input.charAt(i),charMap.getOrDefault(input.charAt(i),0) + 1);
        }
        charMap.entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
        charMap.entrySet()
                .stream()
                .forEach(print -> System.out.println(print.getKey()));
       // for(Map.Entry<Character, Integer> print : charMap.entrySet()){
        //    System.out.println(print.getKey()+":"+print.getValue());
       // }
    }
}
// i want r
