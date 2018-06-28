import java.util.Arrays;
import java.util.Scanner;

public class MinimumUniqueSum {

    private static int minSum(int arr[], int n) {
        int sum = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                int j = i;
                while (j < n && arr[j] <= arr[j - 1]) {
                    arr[j] = arr[j] + 1;
                    j++;
                }
            }
            sum = sum + arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("\n" + minSum(arr, n));
    }
}
