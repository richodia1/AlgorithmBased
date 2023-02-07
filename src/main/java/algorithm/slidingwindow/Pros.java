package algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pros {
int num = 8;
  public static void main(String[] args){
      Map<String, String> map = new HashMap<>();

// Convert all Map keys to a List
      List<String> result = new ArrayList(map.keySet());

// Convert all Map values to a List
      List<String> result2 = new ArrayList(map.values());

// Java 8, Convert all Map keys to a List
      List<String> result3 = map.keySet().stream()
              .collect(Collectors.toList());

// Java 8, Convert all Map values  to a List
      List<String> result4 = map.values().stream()
              .collect(Collectors.toList());

// Java 8, seem a bit long, but you can enjoy the Stream features like filter and etc.
      List<String> result5 = map.values().stream()
              .filter(x -> !"apple".equalsIgnoreCase(x))
              .collect(Collectors.toList());
    }
    public static int solution(String str) {
        int[][]dp = new int[str.length() + 1][str.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else if (i == dp.length - 1) {
                    dp[i][j] = 0;
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else {
                    if (str.charAt(i) == str.charAt(j) && i != j) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
