package codebyteinterview;

public class CompressString {
//aabcccccaaa
public static void main(String[] args) {

    System.out.println(Comp("aabcccccaaa"));
}
static String Comp(String str){
    StringBuilder compress = new StringBuilder();
    int count = 0;
    for (int i = 0; i < str.length(); i++){
        count++;
        if(i + 1 >= str.length() ||str.charAt(i) != str.charAt(i + 1)){
            compress.append(str.charAt(i));
            compress.append(count);
            count = 0;

        }
    }
    return compress.toString();
}
    static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;


            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                compressed.append(str.charAt(i));
                compressed.append( countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed .toString() : str;
    }
}
