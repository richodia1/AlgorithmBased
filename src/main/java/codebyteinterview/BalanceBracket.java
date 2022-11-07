package codebyteinterview;

import java.util.Stack;

public class BalanceBracket {

    public static void main(String[] args){
        System.out.println(isBalanceBracket2("([)"));
    }

    public static boolean isBalanceBracket(String str){
        while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        return (str.length() == 0);
    }
    public static boolean isBalanceBracket2(String str){
        while (str.contains("()") || str.contains("{}") ||str.contains("[]")){
           str = str.replaceAll("\\(\\)","")
                   .replaceAll("\\[\\]","")
                   .replaceAll("\\{\\}","");
        }
        return  str.length() == 0;
    }
}
