import java.util.* ;
import java.io.*; 
public class Solution {
    private static int  count = 0;
    public static long getInversions(long arr[], int n) {
       sort(0, n-1, arr);
       return count;
    }

    private static void sort(int l, int r, long arr[])
    {
      if(l>=r)
      {
          return;
      }
      int mid = l +(r-l)/2;

      sort(l, mid, arr);
      sort(mid+1, r, arr);
            invert(l, mid, r, arr);

      merge(l, mid, r, arr);
    }

    private static void invert(int l, int mid, int r, long[] arr)
    {
          int l1 = l;
          int r1 = mid+1;
          while(l1<= mid &&  r1<=r )
          {
              if(arr[l1]>arr[r1])
              {
                  r1++;
                  count = count + (mid-l1) + 1;
              }
              else{
                 l1++;
              }
          }
    }

    private static void merge(int l, int mid, int r, long[] arr)
    {
          long[] temp = new long[r-l+1];
          int p = 0;
          int l1 = l;
          int r1 = mid+1;
          while(l1<= mid &&  r1<=r )
          {
              if(arr[l1]<arr[r1])
              {
                  temp[p] = arr[l1];
                  l1++;
                  p++;
              }
              else{
                  temp[p] = arr[r1];
                 r1++;
                  p++;
              }
          }

          while(l1<=mid)
          {
                temp[p] = arr[l1];
                  l1++;
                  p++;
          }
          while(r1<=r)
          {
                  temp[p] = arr[r1];
                 r1++;
                  p++;
          }
          p =0;
          for(int s=l;s<=r;s++)
          {
                 arr[s] = temp[p];
                 p++;
          }
    }


}
