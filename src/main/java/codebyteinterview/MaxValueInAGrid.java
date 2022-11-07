package codebyteinterview;

import java.util.List;

/*
Start with an infinite two dimensional grid filled with zeros,
indexed from (1,1) at bottom left corner with coordinates increasing towards the top and right.
Given a series of coordinate (r,c) where r is the ending row and c is the ending column,
add 1 to each element in the range from (1,1) to (r,c) inclusive. Once all coordinates are processed,
determine how many cells contain the maximal value in the grid.
Function countMax with args as an array of strings made of two space-separated integers r and c,
with returning value as number of occurrence of final grid maximal element.
 */
public class MaxValueInAGrid {
    public static long countMax(List<String> upRight) {
        long minRow = Long.MAX_VALUE;
        long minCol = Long.MAX_VALUE;

        for (String str: upRight) {
            long row = Long.parseLong(str.split(" ")[0]);
            long col = Long.parseLong(str.split(" ")[1]);
            minRow = Math.min(minRow, row);
            minCol = Math.min(minCol, col);
        }
        return minRow * minCol;
    }
}
