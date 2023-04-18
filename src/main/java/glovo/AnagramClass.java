package glovo;

import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
public class AnagramClass {

    @Test
    public void TestOne(){
        AnagramClass ana = new AnagramClass();
        assertTrue(ana.isAnagram("rice","ecri"));
        assertNotEquals(ana.isAnagram("rice","ecri"),false);
    }

    public static void main(String[] Args){
        SecureRandom rnd = new SecureRandom ();
        System.out.println(rnd.nextInt(123333));
        /*String input1 ="ABCD", input2 ="DABC";
        boolean result = isAnagram(input1,input2);
        System.out.println(result);

        String inp1 ="AAAB", inp2 ="AAB";
        boolean result2 = isAnagram(inp1,inp2);
        System.out.println(result2);
         */
// NLogN +

    }


    public  boolean isAnagram(String str1,String str2){
          if(str1 == null || str2 == null){
              return false;
          }
        if(str1.length() == str2.length()){
            while (sort(str1).equals(sort(str2))){
                return true;
            }
        }
        return false;
    }
   public  String sort(String str){
        char[] arr =str.toLowerCase().toCharArray();
       Arrays.sort(arr);
      return new String(arr);
   }
}
