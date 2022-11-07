package algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.List;
/*
Maximum Streaks - HackerRank A coin was tossed numerous times.
You need to find the longest streak of tosses resulting Heads and the longest streak of tosses resulting in Tails.
Formally, given the results of tosses of a coin,
find the maximum number of consecutive Heads and the maximum number of consecutive Tails .
 */
public class MaxStreaksCoinsProblem {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> l = new ArrayList<>();
        l.add("Heads");
        l.add("Tails");
        l.add("Tails");
        l.add("Tails");
        l.add("Heads");
        l.add("Heads");
        l.add("Tails");
       var result = getMaxStreaks(l);
       for(int i : result) System.out.println(i);

    }
    public static List<Integer> getMaxStreaks2(List<String> toss){
        List<Integer> res = new ArrayList<>();
        int HCounter = 0;
        int TCounter = 0;
        int Hcount = 0;
        int Tcount = 0;

        for(var tos : toss){
            if(tos.equals("Heads")){
                Tcount = 0;
                Hcount++;
                if(Hcount > HCounter){
                    HCounter = Hcount;
                }
            }else {
                Hcount = 0;
                Tcount++;
                if(Tcount > TCounter){
                    TCounter = Tcount;
                }
            }

        }
        res.add(HCounter);
        res.add(TCounter);
        System.out.println("Head count is : "+HCounter);
        System.out.println("Tail count is : "+TCounter);
        return res;

    }

    public static List<Integer> getMaxStreaks(List<String> toss) {
        // Return an array of two integers containing the maximum streak of heads and
        // tails respectively
        List<Integer> listR = new ArrayList<>();
        int headCountM = 0;
        int tailCountM = 0;

        int headCount = 0;
        int tailCount = 0;

        for (String t : toss) {

            if (t.equals("Heads")) {
                tailCount = 0;

                headCount++;

                if (headCountM < headCount) {
                    headCountM = headCount;
                }

            } else {
                headCount = 0;

                tailCount++;

                if (tailCountM < tailCount) {
                    tailCountM = tailCount;
                }

            }

        }
        listR.add(headCountM);
        listR.add(tailCountM);

        System.out.println("Head : "+headCountM);
        System.out.println("Tails : "+tailCountM);
        return listR;
    }
}
