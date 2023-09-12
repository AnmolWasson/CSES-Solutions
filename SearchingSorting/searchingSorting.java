package SearchingSorting;

import java.util.*;

public class searchingSorting {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       
         ques1();
    }

    static void  ques1() {

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
        Arrays.sort(arr1);

       System.out.println(helpr(arr1,arr2,k));
    }


    static int helpr(int[]arr1,int []arr2,int k) {
            int n =arr1.length,m =arr2.length;
            int i=0,j=0,count=0; 
        while(i<n&&j<m){
            
            int left =arr1[i]-k,right =arr1[i]+k;

            if(left<=arr2[j]&&right>=arr2[j]){

                i++;
                j++;
                count++;
            }

            else if(arr1[i]>arr2[j]){
                j++;
            }

            else{
               i++;
            }
        }

        return count;
    }

       

}
