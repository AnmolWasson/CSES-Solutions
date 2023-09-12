package SearchingSorting;
import java.util.*;

public class searchingSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr2);
        // Arrays.sort(arr1);
        int ans = helpr(arr1, arr2, k);
        System.out.println(ans);
    }

    static int helpr(int[] arr1, int[] arr2, int k) {
         
        int n = arr1.length, count = 0,m=arr2.length;
        boolean[] vis = new boolean[m];
        for (int i = 0; i < n; i++) {

            if (bs(arr1[i], arr2, k,vis)) {
              
                count++;
            }

        }
        return count;
    }

    static boolean bs(int a, int[] arr, int k,boolean[]vis) {

        int lo = 0, hi = arr.length - 1,mod=(int)1e9+7;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;
            if (!vis[mid]&&(arr[mid] >= (a - k)%mod && arr[mid] <= (a + k)%mod)) {
                  
                 hi = mid ;
            }  else if(arr[mid]<(a-k)%mod){
               lo=mid+1;
            }
            else{
                hi=mid;
            }

        }
         
        if(hi>=0&&!vis[hi]&&arr[hi] >= a - k && arr[hi] <= a + k){
            vis[hi]=true;
            return true;
        }

        return false;
    }

}
