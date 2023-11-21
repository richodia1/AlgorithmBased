package Google;

public class NchooseKprograms {
    public int NchooseK(int n, int k){
        if( n == 0 || n == k) return 1;
        return NchooseK(n -1, k -1) + NchooseK(n - 1, k);
    }
}
