import java.util.Arrays;
import java.util.Scanner;

public class CountingPairs {

    private static int countPairs(int arr[], int n, int k) {
        int count = 0;
        Arrays.sort(arr);
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        System.arraycopy(temp, 0, arr, 0, j);
        int left = 0;
        int right = 0;
        while (right < n) {
            if (arr[right] - arr[left] == k) {
                count++;
                left++;
                right++;
            } else if (arr[right] - arr[left] > k)
                left++;
            else
                right++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println("\n" + countPairs(arr, n, k));
    }
}


