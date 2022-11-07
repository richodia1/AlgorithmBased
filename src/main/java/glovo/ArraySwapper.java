package glovo;

import java.util.ArrayList;
import java.util.List;

public class ArraySwapper {
    public static void main(String[] args)
    {
       // var result = Rearrang(new int[] { 1, 3, 4, 1});
       // var result = Rearrang(new int[] {1, 3, 4, 1, 1, 3, 4});
        var result = Rearrang(new int[] { 3, 2, 2, 4 });
        for(int val : result)
        {
            System.out.println(val);
        }

    }
    public static int[] Rearrang(int[] arr)
    {
       List<Integer> threes = new ArrayList<>();
        List<Integer>  fours = new ArrayList<>();
        List<Integer>  others = new ArrayList<>();
        int index = 0;

        for (int value : arr)
        {
            if (value == 3)
                threes.add(index++);

            else if (value == 4 && (index == 0 || !IsPreceededBy3(arr, index)))
                fours.add(index++);

            else others.add(index++);
        }

        index = 0;
        for(int value : threes)
        {
            if (!IsFollowedBy4(arr, value))
                Swap(arr, value + 1, fours.get(index++));
        }

        return arr;
    }

    public static boolean IsFollowedBy4(int[] input, int index)
    {
        if (index == input.length - 1)
            return false;

        else return input[index + 1] == 4;
    }

    public static boolean IsPreceededBy3(int[] input, int index)
    {
        if (index == 0)
            return false;

        else return input[index - 1] == 3;
    }

    public static void Swap(int[] input, int index1, int index2)
    {
        var temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

}
