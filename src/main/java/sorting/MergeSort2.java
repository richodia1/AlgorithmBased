package sorting;

public class MergeSort2 {
    static void Merge(int[] data, int start,int mid, int end){
   int[] temp = new int[end - start + 1];
   int i = start, j = mid + 1, k = 0;
     while (i <= mid && j <=end){
         if(data[i] <= data[j]){
             temp[k++] = data[i++];
         }else{
             temp[k++] = data[j++];
         }
     }
     while (i<= mid){
         temp[k] = data[i];
         k++;i++;
     }
     while ( j <= mid){
         temp[j] = data[j];
         k++;j++;
     }
     for(i = start; i <= end; i++){
         data[i] = temp[i - start];
     }
    }
public static void MergeSort(int[] data, int start, int end){
    while(start < end){
        int mid = (start + end)/2;
        MergeSort(data, start, mid);
        MergeSort(data, mid + 1, end);
        Merge(data, start,mid,end);
    }
}

}
