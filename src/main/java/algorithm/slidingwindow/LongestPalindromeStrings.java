package algorithm.slidingwindow;

public class LongestPalindromeStrings {
    static boolean checkPalindrome(String s)
    {
        int i = 0, j = s.length() - 1;
        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        // Given string is a palindrome
        return true;
    }

    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 1) return s;
        String longest = s.substring(0,1);
        for(int i =0; i < s.length(); i++){
            String temp = printSubStr(s,i,i);
            if(temp.length() > longest.length()){
                longest = temp;
            }

            temp =printSubStr(s,i,i+1);
            if(temp.length() > longest.length()){
                longest = temp;
            }
        }
        return longest;
    }
    public String longestPalindrome2(String s) {
        if(s == null) return null;
        if(s.length() == 1) return s;
        String longest = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
            String temp = printSubPal(s,i,i);
            if(temp.length() > longest.length()){
                longest = temp;
            }
            temp = printSubPal(s,i,i+1);
            if(temp.length() > longest.length()){
                longest = temp;
            }
        }
        return longest;
    }
    static String printSubPal(String s, int low, int high){
        while(low >= 0 && high <= s.length() -1 && s.charAt(low) == s.charAt(high)){
            low--;
            high++;
        }
        return s.substring(low + 1, high);
    }
    static String printSubStr(String s, int low, int high){
        while (low >=0 && high <=s.length() - 1 && s.charAt(low) ==s.charAt(high)){
            low--;
            high++;
        }
        return s.substring(low + 1,high);
    }
}
